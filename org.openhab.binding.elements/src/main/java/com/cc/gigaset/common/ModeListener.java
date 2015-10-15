package com.cc.gigaset.common;


// AWAY, HOME, CUSTOM
public interface ModeListener
	extends Listener {

    void onAway(Base base);

    void onHome(Base base);

    void onCustom(Base base);
}