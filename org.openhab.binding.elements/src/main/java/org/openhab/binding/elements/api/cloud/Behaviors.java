
package org.openhab.binding.elements.api.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Behaviors {

    private String tilt;
    private String open;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The tilt
     */
    public String getTilt() {
        return tilt;
    }

    /**
     *
     * @param tilt
     *            The tilt
     */
    public void setTilt(String tilt) {
        this.tilt = tilt;
    }

    /**
     *
     * @return
     *         The open
     */
    public String getOpen() {
        return open;
    }

    /**
     *
     * @param open
     *            The open
     */
    public void setOpen(String open) {
        this.open = open;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
