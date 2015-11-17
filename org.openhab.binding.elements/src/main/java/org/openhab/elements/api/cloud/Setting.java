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
public class Setting {

    private Behaviors behaviors;
    @SerializedName("endnode_id")
    private String endnodeId;

    /**
     *
     * @return
     *         The behaviors
     */
    public Behaviors getBehaviors() {
        return behaviors;
    }

    /**
     *
     * @param behaviors
     *            The behaviors
     */
    public void setBehaviors(Behaviors behaviors) {
        this.behaviors = behaviors;
    }

    /**
     *
     * @return
     *         The endnodeId
     */
    public String getEndnodeId() {
        return endnodeId;
    }

    /**
     *
     * @param endnodeId
     *            The endnode_id
     */
    public void setEndnodeId(String endnodeId) {
        this.endnodeId = endnodeId;
    }
}