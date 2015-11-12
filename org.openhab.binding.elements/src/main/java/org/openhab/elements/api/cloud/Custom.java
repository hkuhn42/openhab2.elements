
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
@JsonPropertyOrder({
    "settings",
    "sirens_on"
})
public class Custom {

    @JsonProperty("settings")
    private List<Setting> settings = new ArrayList<Setting>();
    @JsonProperty("sirens_on")
    private Boolean sirensOn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The settings
     */
    @JsonProperty("settings")
    public List<Setting> getSettings() {
        return settings;
    }

    /**
     * 
     * @param settings
     *     The settings
     */
    @JsonProperty("settings")
    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    /**
     * 
     * @return
     *     The sirensOn
     */
    @JsonProperty("sirens_on")
    public Boolean getSirensOn() {
        return sirensOn;
    }

    /**
     * 
     * @param sirensOn
     *     The sirens_on
     */
    @JsonProperty("sirens_on")
    public void setSirensOn(Boolean sirensOn) {
        this.sirensOn = sirensOn;
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
