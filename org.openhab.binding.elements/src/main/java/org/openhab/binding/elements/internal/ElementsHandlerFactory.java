/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.elements.internal;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import org.eclipse.smarthome.config.discovery.DiscoveryService;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.elements.ElementsBindingConstants;
import org.openhab.binding.elements.handler.ElementsBridgeHandler;
import org.openhab.binding.elements.handler.ElementsDiscoveryService;
import org.openhab.binding.elements.handler.ElementsThingHandler;
import org.openhab.elements.api.cloud.Sensor;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cc.gigaset.common.SensorType;

/**
 * The {@link ElementsHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author hkuhn42 - Initial contribution
 */
public class ElementsHandlerFactory extends BaseThingHandlerFactory {

    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = new HashSet<ThingTypeUID>();

    private ServiceRegistration<?> discoveryServiceReg;

    static {
        SUPPORTED_THING_TYPES_UIDS.add(ElementsBindingConstants.THING_TYPE_BASE);
        SUPPORTED_THING_TYPES_UIDS.add(ElementsBindingConstants.THING_TYPE_DOOR);
        SUPPORTED_THING_TYPES_UIDS.add(ElementsBindingConstants.THING_TYPE_WINDOW);
        SUPPORTED_THING_TYPES_UIDS.add(ElementsBindingConstants.THING_TYPE_SIREN);
        SUPPORTED_THING_TYPES_UIDS.add(ElementsBindingConstants.THING_TYPE_MOTION);
    }

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {
        ElementsDiscoveryService discoveryService = null;
        if (ElementsBindingConstants.THING_TYPE_BASE.equals(thing.getThingTypeUID())) {
            logger.debug("discovery service register");

            ElementsBridgeHandler bridgetHandler = new ElementsBridgeHandler(thing, discoveryService);

            discoveryService = new ElementsDiscoveryService((Bridge) thing, 15);
            this.discoveryServiceReg = bundleContext.registerService(DiscoveryService.class.getName(), discoveryService,
                    new Hashtable<String, Object>());
            logger.debug("done ElementsDiscoveryService");
            return bridgetHandler;
        }
        return new ElementsThingHandler(thing);
    }

    @Override
    protected void removeHandler(ThingHandler thingHandler) {
        if (ElementsBindingConstants.THING_TYPE_BASE.equals(thingHandler.getThing().getThingTypeUID())) {
            if (this.discoveryServiceReg != null) {
                discoveryServiceReg.unregister();
                discoveryServiceReg = null;
            }
        }
        super.removeHandler(thingHandler);
    }

    public static ThingTypeUID getSensorType(Sensor sensor) {
        ThingTypeUID thingTypeUID = null;
        SensorType type = SensorType.valueOf(sensor.getType());
        switch (type) {
            case DOOR:
                thingTypeUID = ElementsBindingConstants.THING_TYPE_DOOR;
                break;
            case WINDOW:
                thingTypeUID = ElementsBindingConstants.THING_TYPE_WINDOW;
                break;
            case MOTION:
                thingTypeUID = ElementsBindingConstants.THING_TYPE_MOTION;
                break;
            case SIREN:
                thingTypeUID = ElementsBindingConstants.THING_TYPE_SIREN;
                break;
            default:
                thingTypeUID = null;
                break;

        }
        return thingTypeUID;
    }
}