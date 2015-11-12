
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
@JsonPropertyOrder({
    "behaviors",
    "endnode_id"
})
public class Setting {

    @JsonProperty("behaviors")
    private Behaviors behaviors;
    @JsonProperty("endnode_id")
    private String endnodeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The behaviors
     */
    @JsonProperty("behaviors")
    public Behaviors getBehaviors() {
        return behaviors;
    }

    /**
     * 
     * @param behaviors
     *     The behaviors
     */
    @JsonProperty("behaviors")
    public void setBehaviors(Behaviors behaviors) {
        this.behaviors = behaviors;
    }

    /**
     * 
     * @return
     *     The endnodeId
     */
    @JsonProperty("endnode_id")
    public String getEndnodeId() {
        return endnodeId;
    }

    /**
     * 
     * @param endnodeId
     *     The endnode_id
     */
    @JsonProperty("endnode_id")
    public void setEndnodeId(String endnodeId) {
        this.endnodeId = endnodeId;
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
