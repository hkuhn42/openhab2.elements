/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements.api.cloud;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class EventResult {

    private List<Event> events = new ArrayList<Event>();
    @SerializedName("home_state")
    private String homeState;

    /**
     *
     * @return
     *         The events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     *
     * @param events
     *            The events
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     *
     * @return
     *         The homeState
     */
    public String getHomeState() {
        return homeState;
    }

    /**
     *
     * @param homeState
     *            The home_state
     */
    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }
}