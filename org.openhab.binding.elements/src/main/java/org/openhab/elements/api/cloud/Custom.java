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

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Custom {

    private List<Setting> settings = new ArrayList<Setting>();
    @SerializedName("sirens_on")
    private Boolean sirensOn;

    /**
     *
     * @return
     *         The settings
     */
    public List<Setting> getSettings() {
        return settings;
    }

    /**
     *
     * @param settings
     *            The settings
     */
    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    /**
     *
     * @return
     *         The sirensOn
     */
    public Boolean getSirensOn() {
        return sirensOn;
    }

    /**
     *
     * @param sirensOn
     *            The sirens_on
     */
    public void setSirensOn(Boolean sirensOn) {
        this.sirensOn = sirensOn;
    }
}