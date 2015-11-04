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

import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.elements.ElementsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cc.gigaset.common.Base;
import com.cc.gigaset.common.Event;
import com.cc.gigaset.common.Mode;
import com.cc.gigaset.common.Sensor;
import com.cc.gigaset.jersey.GigasetElementsJersey;

/**
 * The {@link ElementsBridgeHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 *
 *
 * @author Harald Kuhn - Initial contribution
 */
public class ElementsBridgeHandler extends BaseThingHandler {

    private GigasetElementsJersey gej;
    private ElementsDiscoveryService service;

    private Logger logger = LoggerFactory.getLogger(ElementsBridgeHandler.class);

    private Base base;

    private ScheduledFuture<?> pollingJob;

    public ElementsBridgeHandler(Thing thing, ElementsDiscoveryService service) {
        super(thing);
        this.service = service;
    }

    private void initBase() {
        Thing bridge = getBridge();
        if (bridge == null) {
            bridge = getThing();
        }
        if (bridge != null) {
            ElementsConfiguration config = bridge.getConfiguration().as(ElementsConfiguration.class);
            logger.info("connection to cloud wither user " + config.getUser());

            if (gej == null) {
                try {
                    gej = new GigasetElementsJersey(config.getUser(), config.getPassword());
                    base = gej.getBase();

                } catch (Exception e) {
                    gej = null;
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initialize() {
        super.initialize();
        try {
            Base base = getBase();
            String mode = base.getMode().toString();
            updateState(new ChannelUID(getThing().getUID(), "mode"), new StringType(mode));
            updateStatus(ThingStatus.ONLINE);
        } catch (Exception e) {
            e.printStackTrace();
            updateStatus(ThingStatus.OFFLINE);
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    ElementsConfiguration config = getThing().getConfiguration().as(ElementsConfiguration.class);
                    gej = new GigasetElementsJersey(config.getUser(), config.getPassword());
                    base = gej.getBase();

                    String mode = base.getMode().toString();
                    updateState(new ChannelUID(getThing().getUID(), "mode"), new StringType(mode));

                    List<Thing> things = ((Bridge) getThing()).getThings();
                    for (Thing thing : things) {
                        ((ElementsThingHandler) thing.getHandler()).refreshStatus();
                    }

                    Collection<Event> events = base.getEvents();
                    for (Event event : events) {
                        logger.debug("elements event registered " + event.getType());
                        // endnode_fw_update_success
                        // movement
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        pollingJob = scheduler.scheduleAtFixedRate(runnable, 0, 30, TimeUnit.SECONDS);
    }

    @Override
    public void dispose() {
        pollingJob.cancel(true);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {

        if (channelUID.getId().equals("mode")) {
            if (command instanceof StringType) {
                Mode mode = null;
                StringType type = (StringType) command;

                switch (type.toString()) {
                    case "HOME":
                        mode = Mode.HOME;
                        break;
                    case "AWAY":
                        mode = Mode.AWAY;
                        break;
                    case "CUSTOM":
                        mode = Mode.CUSTOM;
                        break;
                    default:
                        mode = Mode.HOME;
                        break;
                }
                try {
                    gej.setMode(gej.getBase(), mode);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {

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