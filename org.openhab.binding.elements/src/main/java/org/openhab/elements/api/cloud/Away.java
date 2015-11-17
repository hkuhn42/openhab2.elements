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

import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Away {

    @SerializedName("sirens_on")
    private Boolean sirensOn;

    public Boolean getSirensOn() {
        return sirensOn;
    }

    public void setSirensOn(Boolean sirensOn) {
        this.sirensOn = sirensOn;
    }
}