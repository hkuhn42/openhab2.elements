
package org.openhab.binding.elements.api.cloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class IntrusionSettings {

    private String activeMode;
    private List<Mode> modes = new ArrayList<Mode>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The activeMode
     */
    public String getActiveMode() {
        return activeMode;
    }

    /**
     *
     * @param activeMode
     *            The active_mode
     */
    public void setActiveMode(String activeMode) {
        this.activeMode = activeMode;
    }

    /**
     *
     * @return
     *         The modes
     */
    public List<Mode> getModes() {
        return modes;
    }

    /**
     *
     * @param modes
     *            The modes
     */
    public void setModes(List<Mode> modes) {
        this.modes = modes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
