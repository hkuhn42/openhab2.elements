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
@JsonPropertyOrder({ "home", "away", "custom" })
public class Mode {

    @JsonProperty("home")
    private Home home;
    @JsonProperty("away")
    private Away away;
    @JsonProperty("custom")
    private Custom custom;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The home
     */
    @JsonProperty("home")
    public Home getHome() {
        return home;
    }

    /**
     *
     * @param home
     *            The home
     */
    @JsonProperty("home")
    public void setHome(Home home) {
        this.home = home;
    }

    /**
     *
     * @return
     *         The away
     */
    @JsonProperty("away")
    public Away getAway() {
        return away;
    }

    /**
     *
     * @param away
     *            The away
     */
    @JsonProperty("away")
    public void setAway(Away away) {
        this.away = away;
    }

    /**
     *
     * @return
     *         The custom
     */
    @JsonProperty("custom")
    public Custom getCustom() {
        return custom;
    }

    /**
     *
     * @param custom
     *            The custom
     */
    @JsonProperty("custom")
    public void setCustom(Custom custom) {
        this.custom = custom;
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
