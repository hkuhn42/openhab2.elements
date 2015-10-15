package com.cc.gigaset.common;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface Base {

    String getId();

    Date getDate();

    String getName();

    String getStatus();

    Mode getMode();

    Collection<Sensor> getSensors();

    Collection<Event> getEvents();

    Map<String, Object> getAttributes();
}