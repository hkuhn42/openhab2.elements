package com.cc.gigaset.common;

public enum SensorType {
    DOOR, WINDOW, MOTION, SIREN, CAMERA, OTHER;

    public static SensorType valueOf(Object o) {
	if (o.equals("ds02")) {
	    return DOOR;
	}
	if (o.equals("ws02")) {
	    return WINDOW;
	}
	if (o.equals("ps02")) {
	    return MOTION;
	}
	if (o.equals("is01")) {
	    return SIREN;
	}
	if (o.equals("???")) {
	    return CAMERA;
	}
	return OTHER;
    }
}
