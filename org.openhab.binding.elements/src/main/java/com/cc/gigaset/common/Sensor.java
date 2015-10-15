package com.cc.gigaset.common;

import java.util.Collection;
import java.util.Map;

public interface Sensor {

    Base getBase();

    String getId();

    SensorType getType();

    String getName();

    String getStatus();
    
    String getBattery();

    Collection<Event> getEvents();

    Map<String, Object> getAttributes();
}
