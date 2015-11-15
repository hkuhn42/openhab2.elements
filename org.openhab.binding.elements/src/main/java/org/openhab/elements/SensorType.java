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
 * The {@link SensorType} class defines an enum for all elements sensors
 *
 * @author hkuhn42 - Initial contribution
 */
public enum SensorType {
    DOOR("ds02"),
    WINDOW("ws02"),
    MOTION("ps02"),
    SIREN("is01"),
    OTHER("unknown");

    private final String key;
    private static final Map<String, SensorType> stringToEnum = new HashMap<String, SensorType>();

    SensorType(String key) {
        this.key = key;
    }

    static { // Initialisiert eine Map, die das Mapping von key auf Enum enthaelt
        for (SensorType type : values()) {
            stringToEnum.put(type.toString(), type);
        }
    }

    @Override
    public String toString() {
        return key;
    }

    public static SensorType fromString(String key) {
        if (key != null) {
            if (stringToEnum.get(key) != null) { // returns ProcStatus for key or null
                return stringToEnum.get(key);
            }
            return OTHER;
        }
        return null;
    }

    public static String asString(SensorType procStatus) {
        if (procStatus != null) {
            return procStatus.toString();
        }

        return null;
    }

    public String getKey() {
        return key;
    }
}