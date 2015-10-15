package com.cc.gigaset;

import java.util.List;

import com.cc.gigaset.common.Base;
import com.cc.gigaset.common.Listener;
import com.cc.gigaset.common.Mode;
import com.cc.gigaset.common.ModeListener;
import com.cc.gigaset.common.SensorEventListener;
import com.cc.gigaset.common.SensorListener;
import com.cc.gigaset.common.SensorTypeEventListener;

public interface GigasetElements {

    String getVersion();

    String getUsername();

    Base getBase() throws Exception;

    GigasetElements setLoadEvents(boolean loadEvents);

    boolean isLoadEvents();

    GigasetElements setEventsCount(int eventsCount);

    int getEventsCount();

    GigasetElements setTimeout(int timeout);

    int getTimeout();

    GigasetElements addListener(SensorTypeEventListener listener);

    GigasetElements addListener(SensorEventListener listener);

    GigasetElements addListener(SensorListener listener);

    GigasetElements addListener(ModeListener listener);

    List<Listener> getListeners();

    Base setMode(Base base, Mode mode) throws Exception;

    void setMode(String baseId, Mode mode);
}
