/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@link EventType} class defines an enum for all elements sensors
 *
 * @author hkuhn42 - Initial contribution
 */
public enum EventType {
    MOVEMENT("movement"),
    OPEN("open"),
    CLOSE("close"),
    HOMECOMING("homecoming"),

    SENSOR_OFFLINE("sensor_offline_notification"),
    BASE_OFFLINE("bs_offline_notification"),

    OTHER("unknown"),

    ;

    private final String key;
    private static final Map<String, EventType> stringToEnum = new HashMap<String, EventType>();

    EventType(String key) {
        this.key = key;
    }

    static {
        for (EventType type : values()) {
            stringToEnum.put(type.toString(), type);
        }
    }

    @Override
    public String toString() {
        return key;
    }

    public static EventType fromString(String key) {
        if (key != null) {
            if (stringToEnum.get(key) != null) { // returns EventType for key or null
                return stringToEnum.get(key);
            }
            return OTHER;
        }
        return null;
    }

    public static String asString(EventType procStatus) {
        if (procStatus != null) {
            return procStatus.toString();
        }

        return null;
    }

    public String getKey() {
        return key;
    }
}