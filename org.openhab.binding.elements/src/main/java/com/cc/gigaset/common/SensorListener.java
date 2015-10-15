package com.cc.gigaset.common;


// DOOR, WINDOW, MOTION, SIREN, CAMERA, OTHER
public interface SensorListener
	extends Listener {

    void onDoor(Sensor sensor);

    void onWindow(Sensor sensor);

    void onMotion(Sensor sensor);

    void onSiren(Sensor sensor);

    void onCamera(Sensor sensor);

    void onOther(Sensor sensor);
}