package com.cc.gigaset.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.cc.gigaset.GigasetElements;

public abstract class GigasetElementsBase extends JsonToMapImpl implements GigasetElements {

    private static final String VERSION = "bas-001.000.037";
    // url01
    private static final String url01 = "https://im.gigaset-elements.de";
    private static final String urlIdentity = "identity/api/v1/user/login";
    // url02
    private static final String url02 = "https://api.gigaset-elements.de";
    private static final String urlAuth = "api/v1/auth/openid/begin";// +?op=gigaset
    private static final String urlBase = "api/v1/me/basestations";
    private static final String urlEvents = "api/v1/me/events";// ?limit=1
    // Listener
    private final List<Listener> listeners = Collections.synchronizedList(new LinkedList<Listener>());
    // fields
    private final String username;
    private final String password;
    private int timeout = 90000;
    private int eventsCount = 1;
    boolean loadEvents = true;
    private Base base;

    @SuppressWarnings("unchecked")
    protected GigasetElementsBase(String username, String password) {
        this(username, password, Collections.EMPTY_LIST);
    }

    protected GigasetElementsBase(String username, String password, List<Listener> listeners) {
        super();
        this.username = username;
        this.password = password;
        this.listeners.addAll(listeners);
    }

    @Override
    public final String getVersion() {
        return VERSION;
    }

    @Override
    public final String getUsername() {
        return username;
    }

    @Override
    public final List<Listener> getListeners() {
        return listeners;
    }

    @Override
    public final GigasetElementsBase addListener(ModeListener listener) {
        listeners.add(listener);
        return this;
    }

    @Override
    public final GigasetElementsBase addListener(SensorListener listener) {
        listeners.add(listener);
        return this;
    }

    @Override
    public final GigasetElementsBase addListener(SensorEventListener listener) {
        listeners.add(listener);
        return this;
    }

    @Override
    public final GigasetElementsBase addListener(SensorTypeEventListener listener) {
        listeners.add(listener);
        return this;
    }

    @Override
    public final synchronized int getTimeout() {
        return timeout;
    }

    @Override
    public final synchronized GigasetElementsBase setTimeout(int timeout) {
        this.timeout = Math.max(100, Math.abs(timeout));
        return this;
    }

    @Override
    public final synchronized int getEventsCount() {
        return eventsCount;
    }

    @Override
    public final synchronized GigasetElementsBase setEventsCount(int eventsCount) {
        this.eventsCount = Math.max(1, Math.abs(eventsCount));
        return this;
    }

    @Override
    public final synchronized boolean isLoadEvents() {
        return loadEvents;
    }

    @Override
    public final synchronized GigasetElementsBase setLoadEvents(boolean loadEvents) {
        this.loadEvents = loadEvents;
        return this;
    }

    protected abstract Client newClient();

    protected void decorate(WebTarget target) {
        // do nothing
    }

    @Override
    @SuppressWarnings("unused")
    public synchronized Base getBase() throws Exception {
        base = null;
        // connect
        final Client client = newClient();
        final Date date = Calendar.getInstance().getTime();
        final Cookie authorization = getAuthorization(client);
        // variables
        final StringBuffer baseName = new StringBuffer();
        final StringBuffer baseVersion = new StringBuffer();
        final StringBuffer baseStatus = new StringBuffer();
        final StringBuffer baseMode = new StringBuffer();
        final Map<String, Sensor> sensors = new LinkedHashMap<String, Sensor>();
        final Map<Sensor, Collection<Event>> sensorEvents = new HashMap<Sensor, Collection<Event>>();
        final List<Event> events = new ArrayList<Event>();
        // urlBase
        System.out.println(authorization);

        final WebTarget targetBase = client.target(url02).path(urlBase);
        decorate(targetBase);
        final Response responseBase = targetBase.request(MediaType.APPLICATION_JSON_TYPE).cookie(authorization).get();
        report(responseBase);
        if (responseBase.getStatus() != 200) {
            System.out.println(responseBase.getStatus() + " --> " + responseBase);
            throw new Exception(responseBase.toString());
        }
        final String entityBase = responseBase.readEntity(String.class);
        final Map<String, Object> mapBase = jsonToMap(entityBase);
        System.out.println("--> " + mapBase);
        final MapVisitor visitor01 = new SensorImpl(this, baseStatus, baseVersion, baseMode, baseName, sensorEvents,
                sensors);
        visit(mapBase, visitor01);
        // urlEvents
        if (loadEvents) {
            WebTarget targetEvents = client.target(url02).path(urlEvents).queryParam("limit", getEventsCount());
            decorate(targetEvents);
            Response responseEvents = targetEvents.request(MediaType.APPLICATION_JSON_TYPE).cookie(authorization).get();
            report(responseEvents);
            if (responseEvents.getStatus() != 200) {
                System.out.println(responseEvents.getStatus() + " --> " + responseEvents);
                throw new Exception(responseEvents.toString());
            }
            String entityEvents = responseEvents.readEntity(String.class);
            Map<String, Object> mapEvents = jsonToMap(entityEvents);
            System.out.println("--> " + mapEvents);
            final MapVisitor visitor02 = new MapVisitor() {

                @Override
                public int getMaxLevel() {
                    return Integer.MAX_VALUE;
                }

                @SuppressWarnings("unchecked")
                public void events(int level, final Map<String, Object> values) {
                    if (level == 1) {
                        System.out.println("EVENT >> " + values);
                        // -------------------------------------------------------------------
                        // 2 source_type = basestation
                        // 2 state = ok
                        // 2 source_name = Stazione Base
                        // 2 source_id = A0385DC3CB9D7735DF7DE0B7EA7E2086
                        // 2 type = movement
                        // 2 ts = 1.431968562757E12
                        // 2 o = {friendly_name=Movimento Sala, type=ps02,
                        // id=028b89be9d}
                        // 3 -- friendly_name = Movimento Sala
                        // 3 -- type = ps02
                        // 3 -- id = 028b89be9d
                        // 2 id = b2a1a76a-fd7f-11e4-ac33-02012b05aaf7
                        // -------------------------------------------------------------------
                        final Map<String, Object> o = (Map<String, Object>) values.get("o");
                        final Sensor sensor = sensors.get(o.get("id"));
                        final Calendar eventDate = Calendar.getInstance();
                        eventDate.setTimeInMillis(((Double) values.get("ts")).longValue());
                        Event event = new Event() {

                            @Override
                            public String getId() {
                                return (String) values.get("id");
                            }

                            @Override
                            public Date getDate() {
                                return eventDate.getTime();
                            }

                            @Override
                            public String getState() {
                                return (String) values.get("state");
                            }

                            @Override
                            public String getType() {
                                return (String) values.get("type");
                            }

                            @Override
                            public Sensor getSensor() {
                                return sensor;
                            }

                            @Override
                            public Map<String, Object> getAttributes() {
                                return Collections.unmodifiableMap(values);
                            }
                        };
                        sensorEvents.get(sensor).add(event);
                        events.add(event);
                    }
                }
            };
            visit(mapEvents, visitor02);
        }
        // return base
        base = new Base() {

            private final String name = baseName.toString();
            private final String status = baseStatus.toString();
            private final Mode mode = Mode.valueOf(baseMode.toString());

            @Override
            public String getId() {
                return (String) mapBase.get("id");
            }

            @Override
            public Date getDate() {
                return date;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public String getStatus() {
                return status;
            }

            @Override
            public Mode getMode() {
                return mode;
            }

            @Override
            public Collection<Sensor> getSensors() {
                return Collections.unmodifiableCollection(sensors.values());
            }

            @Override
            public Collection<Event> getEvents() {
                return Collections.unmodifiableList(events);
            }

            @Override
            public Map<String, Object> getAttributes() {
                return Collections.unmodifiableMap(mapBase);
            }
        };
        applyListeners();
        return base;
    }

    private synchronized void applyListeners() {
        for (Listener listener : listeners) {
            if (listener instanceof ModeListener) {
                ModeListener casted = (ModeListener) listener;
                switch (base.getMode()) {
                    case AWAY:
                        casted.onAway(base);
                        break;
                    case CUSTOM:
                        casted.onCustom(base);
                        break;
                    case HOME:
                        casted.onHome(base);
                        break;
                    default:
                        // do nothing
                        break;
                }
            }
        }
        for (Listener listener : listeners) {
            if (listener instanceof SensorListener) {
                SensorListener casted = (SensorListener) listener;
                for (Sensor sensor : base.getSensors()) {
                    switch (sensor.getType()) {
                        case CAMERA:
                            casted.onCamera(sensor);
                            break;
                        case DOOR:
                            casted.onDoor(sensor);
                            break;
                        case MOTION:
                            casted.onMotion(sensor);
                            break;
                        case SIREN:
                            casted.onSiren(sensor);
                            break;
                        case WINDOW:
                            casted.onWindow(sensor);
                            break;
                        default:
                            casted.onOther(sensor);
                            break;
                    }
                }
            }
        }
        for (Listener listener : listeners) {
            if (listener instanceof SensorEventListener) {
                SensorEventListener casted = (SensorEventListener) listener;
                for (Event event : base.getEvents()) {
                    if (event.getSensor().getId().equals(casted.getSensor().getId())) {
                        casted.onEvent(event);
                    }
                }
            }
        }
        for (Listener listener : listeners) {
            if (listener instanceof SensorTypeEventListener) {
                SensorTypeEventListener casted = (SensorTypeEventListener) listener;
                for (Event event : base.getEvents()) {
                    if (event.getSensor().getType().equals(casted.getSensorType())) {
                        casted.onEvent(event);
                    }
                }
            }
        }
    }

    synchronized Base base() {
        return base;
    }

    protected Cookie getAuthorization(Client client) {
        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // urlIdentity
        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        WebTarget targetIdentity = client.target(url01).path(urlIdentity);
        decorate(targetIdentity);
        Form form = new Form();
        form.param("email", username);
        form.param("password", password);

        System.out.println(username + " " + password);

        Response responseIdentity = targetIdentity.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        report(responseIdentity);
        if (responseIdentity.getStatus() != 200) {
            System.out.println(responseIdentity.getStatus() + " --> " + responseIdentity);
            throw new RuntimeException(responseIdentity.toString());
        }
        String entityIdentity = responseIdentity.readEntity(String.class);
        System.out.println("1--> " + entityIdentity);
        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // urlAuth
        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        WebTarget targetAuth = client.target(url02).path(urlAuth).queryParam("op", "gigaset");
        decorate(targetAuth);
        Response responseAuth = targetAuth.request(MediaType.TEXT_PLAIN_TYPE).cookie(getFirstCookie(responseIdentity))
                .get();
        report(responseAuth);
        if (responseAuth.getStatus() != 200) {
            System.out.println(responseAuth.getStatus() + " --> " + responseAuth);
            throw new RuntimeException(responseAuth.toString());
        }
        String entityAuth = responseAuth.readEntity(String.class);
        System.out.println("2--> " + entityAuth);
        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // authorization
        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        return getFirstCookie(responseAuth);
    }

    private static Cookie getFirstCookie(Response response) {
        for (String key : response.getCookies().keySet()) {
            return response.getCookies().get(key);
        }
        return null;
    }

    @Override
    public Base setMode(final Base base, Mode mode) throws Exception {
        setMode(base.getId(), mode);
        return getBase();
    }

    @Override
    public void setMode(String baseId, Mode mode) {
        // connect
        final Client client = newClient();
        final Cookie authorization = getAuthorization(client);
        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // urlBase
        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        WebTarget targetSetMode = client.target(url02).path(urlBase.concat("/").concat(baseId));
        decorate(targetSetMode);
        String json = "{ 'intrusion_settings' : { 'active_mode' : '" + mode.name().toLowerCase() + "' }}";
        json = json.replace("'", "\"");
        Response responseSetMode = targetSetMode.request(MediaType.TEXT_PLAIN_TYPE).cookie(authorization)
                .post(Entity.entity(json, MediaType.TEXT_PLAIN_TYPE));
        report(responseSetMode);
        String entitySetMode = responseSetMode.readEntity(String.class);
        System.out.println("--> " + entitySetMode);
    }

    private static final String EC1 = "--------------------------------------------------------------------------------------------------------------------------------";
    private static final String EC2 = EC1.replace("-", "#");
    public static final AtomicBoolean DEBUG = new AtomicBoolean(false);

    protected void report(Response response) {
        if (DEBUG.get()) {
            System.out.println();
            System.out.println(EC2 + EC2 + EC2);
            System.out.println(response.getStatus() + " (" + response.getStatusInfo() + ")" + ": " + response);
            System.out.println(EC2 + EC2 + EC2);
            System.out.println("MediaType: " + response.getMediaType());
            System.out.println(EC1 + EC1 + EC1);
            if (!response.getHeaders().isEmpty()) {
                for (String key : response.getHeaders().keySet()) {
                    System.out.println(key + " " + response.getHeaders().get(key));
                }
            } else {
                System.out.println("no Headers");
            }
            System.out.println(EC1 + EC1 + EC1);
            if (!response.getCookies().isEmpty()) {
                for (String key : response.getCookies().keySet()) {
                    NewCookie cookie = response.getCookies().get(key);
                    System.out.println(key + " " + cookie);
                }
            } else {
                System.out.println("no Cookies");
            }
            System.out.println(EC1 + EC1 + EC1);
            if (!response.getAllowedMethods().isEmpty()) {
                for (String key : response.getAllowedMethods()) {
                    System.out.println(key);
                }
            } else {
                System.out.println("no AllowedMethods");
            }
            System.out.println();
        }
    }

    @Override
    public final String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName() + " [username=");
        builder.append(username);
        builder.append("]");
        return builder.toString();
    }
}
