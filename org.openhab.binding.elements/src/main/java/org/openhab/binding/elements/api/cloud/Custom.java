
package org.openhab.binding.elements.api.cloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Custom {

    private List<Setting> settings = new ArrayList<Setting>();
    private Boolean sirensOn;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The settings
     */
    public List<Setting> getSettings() {
        return settings;
    }

    /**
     *
     * @param settings
     *            The settings
     */
    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    /**
     *
     * @return
     *         The sirensOn
     */
    public Boolean getSirensOn() {
        return sirensOn;
    }

    /**
     *
     * @param sirensOn
     *            The sirens_on
     */
    public void setSirensOn(Boolean sirensOn) {
        this.sirensOn = sirensOn;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
