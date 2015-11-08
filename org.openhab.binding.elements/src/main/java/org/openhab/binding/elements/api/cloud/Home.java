
package org.openhab.binding.elements.api.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Home {

    private Boolean sirensOn;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
