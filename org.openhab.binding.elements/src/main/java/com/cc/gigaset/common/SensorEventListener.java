package com.cc.gigaset.common;


public abstract class SensorEventListener
	implements Listener {

    private final Sensor sensor;

    public SensorEventListener(Sensor sensor) {
	super();
	this.sensor = sensor;
    }

    public final Sensor getSensor() {
	return sensor;
    }

    public abstract void onEvent(Event event);
}
