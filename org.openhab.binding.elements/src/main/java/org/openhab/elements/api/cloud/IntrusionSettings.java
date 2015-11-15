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
import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({ "active_mode", "modes" })
public class IntrusionSettings {

    @JsonProperty("active_mode")
    private String activeMode;
    @JsonProperty("modes")
    private List<Mode> modes = new ArrayList<Mode>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The activeMode
     */
    @JsonProperty("active_mode")
    public String getActiveMode() {
        return activeMode;
    }

    /**
     *
     * @param activeMode
     *            The active_mode
     */
    @JsonProperty("active_mode")
    public void setActiveMode(String activeMode) {
        this.activeMode = activeMode;
    }

    /**
     *
     * @return
     *         The modes
     */
    @JsonProperty("modes")
    public List<Mode> getModes() {
        return modes;
    }

    /**
     *
     * @param modes
     *            The modes
     */
    @JsonProperty("modes")
    public void setModes(List<Mode> modes) {
        this.modes = modes;
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
