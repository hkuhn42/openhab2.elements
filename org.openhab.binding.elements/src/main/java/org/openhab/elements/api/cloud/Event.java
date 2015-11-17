/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements.api.cloud;

import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("source_type")
    private String sourceType;
    private String state;
    @SerializedName("source_name")
    private String sourceName;
    @SerializedName("source_id")
    private String sourceId;
    private String type;
    private Long ts;
    private Origin o;
    private String id;

    /**
     *
     * @return
     *         The sourceType
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     *
     * @param sourceType
     *            The source_type
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    /**
     *
     * @return
     *         The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     *            The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     *         The sourceName
     */

    public String getSourceName() {
        return sourceName;
    }

    /**
     *
     * @param sourceName
     *            The source_name
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    /**
     *
     * @return
     *         The sourceId
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     *
     * @param sourceId
     *            The source_id
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
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
     *         The ts
     */
    public Long getTs() {
        return ts;
    }

    /**
     *
     * @param ts
     *            The ts
     */
    public void setTs(Long ts) {
        this.ts = ts;
    }

    /**
     *
     * @return
     *         The o
     */
    public Origin getO() {
        return o;
    }

    /**
     *
     * @param o
     *            The o
     */
    public void setO(Origin o) {
        this.o = o;
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
