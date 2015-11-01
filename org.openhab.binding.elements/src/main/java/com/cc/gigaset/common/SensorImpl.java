package com.cc.gigaset.common;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

public final class SensorImpl implements MapVisitor {

    private GigasetElementsBase base;
    private final StringBuffer baseStatus;
    private final StringBuffer baseVersion;
    private final StringBuffer baseMode;
    private final StringBuffer baseName;
    private final Map<Sensor, Collection<Event>> sensorEvents;
    private final Map<String, Sensor> sensors;

    public SensorImpl(GigasetElementsBase base, StringBuffer baseStatus, StringBuffer baseVersion,
            StringBuffer baseMode, StringBuffer baseName, Map<Sensor, Collection<Event>> sensorEvents,
            Map<String, Sensor> sensors) {
        this.base = base;
        this.baseStatus = baseStatus;
        this.baseVersion = baseVersion;
        this.baseMode = baseMode;
        this.baseName = baseName;
        this.sensorEvents = sensorEvents;
        this.sensors = sensors;
    }

    @Override
    public int getMaxLevel() {
        return Integer.MAX_VALUE;
    }

    public void status(int level, Object value) {
        if (level == 0) {
            System.out.println("STATUS >> " + value);
            baseStatus.append(value.toString());
        }
    }

    public void version(int level, Object value) {
        if (level == 0) {
            System.out.println("VERSION >> " + value);
            baseVersion.append(value.toString());
        }
    }

    public void active_mode(int level, Object value) {
        if (level == 1) {
            System.out.println("MODE >> " + value);
            baseMode.append(value.toString().toUpperCase());
        }
    }

    public void friendly_name(int level, Object value) {
        if (level == 0) {
            System.out.println("NAME >> " + value);
            baseName.append(value.toString());
        }
    }

    public void sensors(int level, final Map<String, Object> values) {
        if (level == 1) {
            System.out.println("SENSOR >> " + values);
            // -------------------------------------------------------------------
            // 2 status = online
            // 2 position_status = closed
            // 2 battery = {state=ok}
            // 3 -- state = ok
            // 2 ts_button = 1.429639541039E12
            // 2 friendly_name = Porta Garage
            // 2 latest_version = 004100001025000001010e00
            // 2 fw_version = 004100001025000001010e00
            // 2 firmware_status = up_to_date
            // 2 type = ds02
            // 2 id = 025bc8a68a
            // -------------------------------------------------------------------
            Sensor sensor = new Sensor() {

                @Override
                public Base getBase() {
                    try {
                        return base.getBase();
                    } catch (Exception e) {
                        throw new RuntimeException(e);

                    }
                }

                @Override
                public String getId() {
                    return (String) values.get("id");
                }

                @Override
                public String getName() {
                    return (String) values.get("friendly_name");
                }

                @Override
                public SensorType getType() {
                    return SensorType.valueOf(values.get("type"));
                }

                @Override
                public String getStatus() {
                    return (String) values.get("status");
                }

                @Override
                public String getBattery() {
                    Object value = values.get("battery");
                    if (value == null) {
                        return "";
                    }
                    if (value instanceof String) {
                        return (String) value;
                    } else if (value instanceof Map) {
                        Map subValue = (Map) value;
                        return (String) subValue.get("state");
                    } else {
                        return value.toString();
                    }

                }

                @Override
                public Collection<Event> getEvents() {
                    return Collections.unmodifiableCollection(sensorEvents.get(this));
                }

                @Override
                public Map<String, Object> getAttributes() {
                    return Collections.unmodifiableMap(values);
                }
            };
            sensorEvents.put(sensor, new LinkedList<Event>());
            sensors.put(sensor.getId(), sensor);
        }
    }
}