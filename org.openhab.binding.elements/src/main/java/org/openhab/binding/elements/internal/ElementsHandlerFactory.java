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
import org.openhab.binding.elements.handler.ElementsDiscoveryService;
import org.openhab.binding.elements.handler.ElementsHandler;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link ElementsHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author hkuhn42 - Initial contribution
 */
public class ElementsHandlerFactory extends BaseThingHandlerFactory {

    private final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = new HashSet<ThingTypeUID>();

    private ServiceRegistration<?> discoveryServiceReg;

    static {
        SUPPORTED_THING_TYPES_UIDS.add(ElementsBindingConstants.THING_TYPE_BASE);
    }

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        // return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
        return true;
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {
        if (false && ElementsBindingConstants.THING_TYPE_BASE.equals(thing.getThingTypeUID())) {
            // AvmDiscoveryService discoveryService = new AvmDiscoveryService(handler);
            // this.discoveryServiceRegs.put(handler.getThing().getUID(), bundleContext.registerService(
            // DiscoveryService.class.getName(), discoveryService, new Hashtable<String, Object>()));

            ElementsDiscoveryService discoveryService = new ElementsDiscoveryService((Bridge) thing, 15);
            // discoveryService.activate(null);
            this.discoveryServiceReg = bundleContext.registerService(DiscoveryService.class.getName(), discoveryService,
                    new Hashtable<String, Object>());
        }
        return new ElementsHandler(thing);
    }

    @Override
    protected void removeHandler(ThingHandler thingHandler) {
        if (ElementsBindingConstants.THING_TYPE_BASE.equals(thingHandler.getThing().getThingTypeUID())) {
            if (this.discoveryServiceReg != null) {
                // MaxDeviceDiscoveryService service = (MaxDeviceDiscoveryService)
                // bundleContext.getService(discoveryServiceReg.getReference());
                // service.deactivate();
                discoveryServiceReg.unregister();
                discoveryServiceReg = null;
            }
        }
        super.removeHandler(thingHandler);
    }

    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Service registration map
     */
    // private Map<ThingUID, ServiceRegistration<?>> discoveryServiceRegs = new HashMap<>();
    //
    // /**
    // * Remove handler of things.
    // */
    // @Override
    // protected synchronized void removeHandler(ThingHandler thingHandler) {
    //
    // ServiceRegistration<?> serviceReg = this.discoveryServiceRegs.get(thingHandler.getThing().getUID());
    // if (serviceReg != null) {
    // serviceReg.unregister();
    // discoveryServiceRegs.remove(thingHandler.getThing().getUID());
    // }
    // }

}