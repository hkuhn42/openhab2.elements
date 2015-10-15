/**

 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.elements;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link ElementsBinding} class defines common constants, which are
 * used across the whole binding.
 *
 * @author hkuhn42 - Initial contribution
 */
public class ElementsBindingConstants {

    public static final String BINDING_ID = "elements";

    // List of all Thing Type UIDs
    public final static ThingTypeUID THING_TYPE_BASE = new ThingTypeUID(BINDING_ID, "base");

    public final static ThingTypeUID THING_TYPE_WINDOW = new ThingTypeUID(BINDING_ID, "window");

    public final static ThingTypeUID THING_TYPE_DOOR = new ThingTypeUID(BINDING_ID, "door");

    public final static ThingTypeUID THING_TYPE_SIREN = new ThingTypeUID(BINDING_ID, "siren");

    public final static ThingTypeUID THING_TYPE_MOTION = new ThingTypeUID(BINDING_ID, "motion");

    public final static ThingTypeUID THING_TYPE_PLUG = new ThingTypeUID(BINDING_ID, "plug");

    // List of all Channel ids
    public final static String CHANNEL_1 = "channel1";

}
