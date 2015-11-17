/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements.api.cloud;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class BaseConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("intrusion_settings")
    private IntrusionSettings intrusionSettings;

    /**
     *
     * @return
     *         The intrusionSettings
     */
    public IntrusionSettings getIntrusionSettings() {
        return intrusionSettings;
    }

    /**
     *
     * @param intrusionSettings
     *            The intrusion_settings
     */
    public void setIntrusionSettings(IntrusionSettings intrusionSettings) {
        this.intrusionSettings = intrusionSettings;
    }
}
