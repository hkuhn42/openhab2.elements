package com.cc.gigaset.common;


public abstract class SensorTypeEventListener
	implements Listener {

    private final SensorType sensorType;

    public SensorTypeEventListener(SensorType sensorType) {
	super();
	this.sensorType = sensorType;
    }

    public final SensorType getSensorType() {
	return sensorType;
    }

    public abstract void onEvent(Event event);
}
