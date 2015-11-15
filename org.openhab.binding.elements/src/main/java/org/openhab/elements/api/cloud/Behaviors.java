/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements.api.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "tilt", "open" })
public class Behaviors {

    @JsonProperty("tilt")
    private String tilt;
    @JsonProperty("open")
    private String open;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The tilt
     */
    @JsonProperty("tilt")
    public String getTilt() {
        return tilt;
    }

    /**
     *
     * @param tilt
     *            The tilt
     */
    @JsonProperty("tilt")
    public void setTilt(String tilt) {
        this.tilt = tilt;
    }

    /**
     *
     * @return
     *         The open
     */
    @JsonProperty("open")
    public String getOpen() {
        return open;
    }

    /**
     *
     * @param open
     *            The open
     */
    @JsonProperty("open")
    public void setOpen(String open) {
        this.open = open;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
