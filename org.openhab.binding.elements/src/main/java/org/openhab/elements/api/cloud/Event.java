
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
@JsonPropertyOrder({ "source_type", "state", "source_name", "source_id", "type", "ts", "o", "id", "parents" })
public class Event {

    @JsonProperty("source_type")
    private String sourceType;
    @JsonProperty("state")
    private String state;
    @JsonProperty("source_name")
    private String sourceName;
    @JsonProperty("source_id")
    private String sourceId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("ts")
    private Long ts;
    @JsonProperty("o")
    private Origin o;
    @JsonProperty("id")
    private String id;
    @JsonProperty("parents")
    private List<String> parents = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The sourceType
     */
    @JsonProperty("source_type")
    public String getSourceType() {
        return sourceType;
    }

    /**
     *
     * @param sourceType
     *            The source_type
     */
    @JsonProperty("source_type")
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    /**
     *
     * @return
     *         The state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     *            The state
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     *         The sourceName
     */
    @JsonProperty("source_name")
    public String getSourceName() {
        return sourceName;
    }

    /**
     *
     * @param sourceName
     *            The source_name
     */
    @JsonProperty("source_name")
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    /**
     *
     * @return
     *         The sourceId
     */
    @JsonProperty("source_id")
    public String getSourceId() {
        return sourceId;
    }

    /**
     *
     * @param sourceId
     *            The source_id
     */
    @JsonProperty("source_id")
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     *
     * @return
     *         The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *            The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *         The ts
     */
    @JsonProperty("ts")
    public Long getTs() {
        return ts;
    }

    /**
     *
     * @param ts
     *            The ts
     */
    @JsonProperty("ts")
    public void setTs(Long ts) {
        this.ts = ts;
    }

    /**
     *
     * @return
     *         The o
     */
    @JsonProperty("o")
    public Origin getO() {
        return o;
    }

    /**
     *
     * @param o
     *            The o
     */
    @JsonProperty("o")
    public void setO(Origin o) {
        this.o = o;
    }

    /**
     *
     * @return
     *         The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *            The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     *         The parents
     */
    @JsonProperty("parents")
    public List<String> getParents() {
        return parents;
    }

    /**
     *
     * @param parents
     *            The parents
     */
    @JsonProperty("parents")
    public void setParents(List<String> parents) {
        this.parents = parents;
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
