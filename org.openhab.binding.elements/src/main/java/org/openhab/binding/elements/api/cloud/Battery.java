
package org.openhab.binding.elements.api.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Battery {

    private String state;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
