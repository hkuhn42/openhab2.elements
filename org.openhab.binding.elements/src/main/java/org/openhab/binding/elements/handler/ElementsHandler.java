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

import java.util.Set;

import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.elements.ElementsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cc.gigaset.common.Mode;
import com.cc.gigaset.jersey.GigasetElementsJersey;

/**
 * The {@link ElementsHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 *
 *
 * @author Harald Kuhn - Initial contribution
 */
public class ElementsHandler extends BaseThingHandler {

    GigasetElementsJersey gej;

    private Logger logger = LoggerFactory.getLogger(ElementsHandler.class);

    public ElementsHandler(Thing thing) {
        super(thing);
        logger.debug("new elements handler for:" + thing.getThingTypeUID().getAsString());
        if ("elements:base".equalsIgnoreCase(thing.getThingTypeUID().getAsString())) {
            Set<String> keys = thing.getConfiguration().getProperties().keySet();
            // logger.debug("param dumb for " + thing.getThingTypeUID().getAsString());
            // for (String string : keys) {
            // logger.debug(string);
            // }
            // logger.debug("xxxxxxxxxxxxxxxxxxx" + thing.getBridgeUID());

            ElementsConfiguration config = this.getConfigAs(ElementsConfiguration.class);
            logger.info("connection to cloud wither user " + config.getUser());

            if (gej == null) {
                try {
                    gej = new GigasetElementsJersey(config.getUser(), config.getPassword());
                    // Base base = gej.getBase();
                    // Collection<Sensor> sensors = base.getSensors();
                    // for (Sensor sensor : sensors) {
                    // System.out.println(sensor.getName() + " " + sensor.getType() + " " + sensor.getStatus() + " "
                    // + sensor.getAttributes());
                    // }

                    // thing.setProperty(name, value)
                    String mode = gej.getBase().getMode().toString();
                    // updateState(new ChannelUID(getThing().getUID(), "mode"), new StringType(mode));
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

        // Sensor

        logger.debug("gigaset " + channelUID + " " + command);
    }

}
