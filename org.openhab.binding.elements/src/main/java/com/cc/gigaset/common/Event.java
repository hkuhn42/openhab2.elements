package com.cc.gigaset.common;

import java.util.Date;
import java.util.Map;

public interface Event {

    String getId();

    Date getDate();

    String getState();

    String getType();

    Sensor getSensor();

    Map<String, Object> getAttributes();
}
