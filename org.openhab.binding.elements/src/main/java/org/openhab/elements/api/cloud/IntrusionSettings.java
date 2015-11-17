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
public class IntrusionSettings {

    @SerializedName("active_mode")
    private String activeMode;
    private List<Mode> modes = new ArrayList<Mode>();

    /**
     *
     * @return
     *         The activeMode
     */
    public String getActiveMode() {
        return activeMode;
    }

    /**
     *
     * @param activeMode
     *            The active_mode
     */
    public void setActiveMode(String activeMode) {
        this.activeMode = activeMode;
    }

    /**
     *
     * @return
     *         The modes
     */
    public List<Mode> getModes() {
        return modes;
    }

    /**
     *
     * @param modes
     *            The modes
     */
    public void setModes(List<Mode> modes) {
        this.modes = modes;
    }
}
