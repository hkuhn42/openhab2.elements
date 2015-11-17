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
public class Origin {

    @SerializedName("friendly_name")
    private String friendlyName;
    private String type;
    private String id;

    /**
     *
     * @return
     *         The friendlyName
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     *
     * @param friendlyName
     *            The friendly_name
     */
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     *
     * @return
     *         The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *            The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *         The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *            The id
     */
    public void setId(String id) {
        this.id = id;
    }
}
