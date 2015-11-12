/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.elements.handler;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.NotAuthorizedException;

import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.elements.ElementsConfiguration;
import org.openhab.elements.ElementsClient2;
import org.openhab.elements.api.cloud.Base;
import org.openhab.elements.api.cloud.Event;
import org.openhab.elements.api.cloud.EventResult;
import org.openhab.elements.api.cloud.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link ElementsBridgeHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 *
 *
 * @author Harald Kuhn - Initial contribution
 */
public class ElementsBridgeHandler extends BaseThingHandler {

    private ElementsClient2 client;
    private ElementsDiscoveryService service;
    private String usertoken;

    private Logger logger = LoggerFactory.getLogger(ElementsBridgeHandler.class);

    private Base base;

    private ScheduledFuture<?> baseRefreshJob;
    private ScheduledFuture<?> eventsJob;

    public ElementsBridgeHandler(Thing thing, ElementsDiscoveryService service) {
        super(thing);
        this.service = service;
    }

    private void initBase() {
        Thing bridge = getThing();
        if (bridge != null) {
            ElementsConfiguration config = bridge.getConfiguration().as(ElementsConfiguration.class);
            logger.info("connection to cloud wither user " + config.getUser());

            if (client == null) {
                try {
                    client = new ElementsClient2();

                    try {
                        if (usertoken == null) {
                            usertoken = client.getUserToken(config.getUser(), config.getPassword());
                            client.getBase(usertoken);
                        }
                        Base[] bases = client.getBase(usertoken);
                        base = bases[0];
                    } catch (NotAuthorizedException e) {
                        usertoken = client.getUserToken(config.getUser(), config.getPassword());
                        Base[] bases = client.getBase(usertoken);
                        base = bases[0];
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initialize() {
        super.initialize();
        try {
            initBase();
            if (base != null) {
                String mode = base.getIntrusionSettings().getActiveMode();
                updateState(new ChannelUID(getThing().getUID(), "mode"), new StringType(mode));
                updateStatus(ThingStatus.ONLINE);

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            initBase();
                            if (base != null) {
                                String mode = base.getIntrusionSettings().getActiveMode();
                                updateState(new ChannelUID(getThing().getUID(), "mode"), new StringType(mode));

                                List<Thing> things = ((Bridge) getThing()).getThings();
                                for (Thing thing : things) {
                                    ((ElementsThingHandler) thing.getHandler()).refreshStatus();
                                }
                            } else {
                                System.err.println("base is null");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                baseRefreshJob = scheduler.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.MINUTES);

                runnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            EventResult eventResult = client.getEvents(usertoken);
                            for (Event event : eventResult.getEvents()) {
                                event.getType();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                eventsJob = scheduler.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.SECONDS);

            } else {
                updateStatus(ThingStatus.OFFLINE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            updateStatus(ThingStatus.OFFLINE);
        }

    }

    @Override
    public void dispose() {
        baseRefreshJob.cancel(true);
        eventsJob.cancel(true);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {

        if (channelUID.getId().equals("mode")) {
            if (command instanceof StringType) {
                StringType type = (StringType) command;
                try {
                    ElementsConfiguration config = getThing().getConfiguration().as(ElementsConfiguration.class);
                    try {
                        // gej.setMode(gej.getBase(), mode);
                        String usertoken = getThing().getProperties().get("usertoken");
                        if (usertoken == null) {
                            usertoken = client.getUserToken(config.getUser(), config.getPassword());
                            client.setMode(base.getId(), type.toString(), usertoken);
                        }
                        client.setMode(base.getId(), type.toString(), usertoken);
                    } catch (NotAuthorizedException e) {
                        usertoken = client.getUserToken(config.getUser(), config.getPassword());
                        client.setMode(base.getId(), type.toString(), usertoken);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        if (channelUID.getId().equals("discover")) {
            service.scan();
            updateState(new ChannelUID(getThing().getUID(), "discover"), OnOffType.OFF);
        }
        // Sensor
        logger.debug("########### gigaset channel " + channelUID + " gets command " + command + " ##############");
    }

    public Base getBase() {
        if (base == null) {
            initBase();
        }
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public Collection<Sensor> getSensors() {
        return getBase().getSensors();
    }

    public Sensor getSensor(String id) {
        Collection<Sensor> sensors = getSensors();
        if (sensors == null) {
            return null;
        }
        for (Sensor sensor : sensors) {
            if (id != null && id.equalsIgnoreCase(sensor.getId())) {
                return sensor;
            }
        }
        return null;
    }
}