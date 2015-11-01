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

import java.util.Map;

import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.elements.ElementsBindingConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cc.gigaset.common.Sensor;

/**
 * The {@link ElementsThingHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 *
 *
 * @author Harald Kuhn - Initial contribution
 */
public class ElementsThingHandler extends BaseThingHandler {

    private Logger logger = LoggerFactory.getLogger(ElementsThingHandler.class);

    public ElementsThingHandler(Thing thing) {
        super(thing);
        logger.debug("new elements handler for:" + thing.getThingTypeUID().getAsString());
    }

    @Override
    public void initialize() {
        super.initialize();

        Sensor thisSensor = getThisSensor();
        if (thisSensor != null) {
            updateStatus(ThingStatus.ONLINE);
            if (ElementsBindingConstants.THING_TYPE_DOOR.equals(thing.getThingTypeUID())
                    || ElementsBindingConstants.THING_TYPE_WINDOW.equals(thing.getThingTypeUID())
                    || ElementsBindingConstants.THING_TYPE_MOTION.equals(thing.getThingTypeUID())) {
                logger.info("battery status is " + thisSensor.getBattery());
                updateState(new ChannelUID(getThing().getUID(), "battery"), new StringType(thisSensor.getBattery()));
            }
            Map<String, Object> attrs = thisSensor.getAttributes();
            String firmwareStatus = attrs.get("firmware_status").toString();
            String state = thisSensor.getStatus();
            updateState(new ChannelUID(getThing().getUID(), "firmwareStatus"), new StringType(firmwareStatus));
        } else {
            updateStatus(ThingStatus.OFFLINE);
        }
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        logger.debug("### gigaset channel " + channelUID + " gets command " + command + " ###");
    }

    public Sensor getThisSensor() {
        if (getBridge() != null && getBridge().getHandler() != null) {
            ElementsBridgeHandler handler = (ElementsBridgeHandler) getBridge().getHandler();
            return handler.getSensor(thing.getUID().getId());
        }
        return null;

    }
}