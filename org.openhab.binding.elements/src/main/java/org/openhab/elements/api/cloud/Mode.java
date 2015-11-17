/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements.api.cloud;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Mode {

    private Home home;
    private Away away;
    private Custom custom;

    /**
     *
     * @return
     *         The home
     */
    public Home getHome() {
        return home;
    }

    /**
     *
     * @param home
     *            The home
     */
    public void setHome(Home home) {
        this.home = home;
    }

    /**
     *
     * @return
     *         The away
     */
    public Away getAway() {
        return away;
    }

    /**
     *
     * @param away
     *            The away
     */
    public void setAway(Away away) {
        this.away = away;
    }

    /**
     *
     * @return
     *         The custom
     */
    public Custom getCustom() {
        return custom;
    }

    /**
     *
     * @param custom
     *            The custom
     */
    public void setCustom(Custom custom) {
        this.custom = custom;
    }
}
