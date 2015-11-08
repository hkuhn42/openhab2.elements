
package org.openhab.binding.elements.api.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Setting {

    private Behaviors behaviors;
    private String endnodeId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The behaviors
     */
    public Behaviors getBehaviors() {
        return behaviors;
    }

    /**
     *
     * @param behaviors
     *            The behaviors
     */
    public void setBehaviors(Behaviors behaviors) {
        this.behaviors = behaviors;
    }

    /**
     *
     * @return
     *         The endnodeId
     */
    public String getEndnodeId() {
        return endnodeId;
    }

    /**
     *
     * @param endnodeId
     *            The endnode_id
     */
    public void setEndnodeId(String endnodeId) {
        this.endnodeId = endnodeId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
