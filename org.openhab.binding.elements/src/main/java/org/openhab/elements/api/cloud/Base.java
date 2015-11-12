
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
    "status",
    "version",
    "endnodes",
    "friendly_name",
    "latest_version",
    "fw_outdated",
    "intrusion_settings",
    "updates_available",
    "timezone",
    "sensors",
    "firmware_status",
    "id"
})
public class Base {

    @JsonProperty("status")
    private String status;
    @JsonProperty("version")
    private String version;
    @JsonProperty("endnodes")
    private List<Endnode> endnodes = new ArrayList<Endnode>();
    @JsonProperty("friendly_name")
    private String friendlyName;
    @JsonProperty("latest_version")
    private String latestVersion;
    @JsonProperty("fw_outdated")
    private Boolean fwOutdated;
    @JsonProperty("intrusion_settings")
    private IntrusionSettings intrusionSettings;
    @JsonProperty("updates_available")
    private Boolean updatesAvailable;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("sensors")
    private List<Sensor> sensors = new ArrayList<Sensor>();
    @JsonProperty("firmware_status")
    private String firmwareStatus;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The version
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The endnodes
     */
    @JsonProperty("endnodes")
    public List<Endnode> getEndnodes() {
        return endnodes;
    }

    /**
     * 
     * @param endnodes
     *     The endnodes
     */
    @JsonProperty("endnodes")
    public void setEndnodes(List<Endnode> endnodes) {
        this.endnodes = endnodes;
    }

    /**
     * 
     * @return
     *     The friendlyName
     */
    @JsonProperty("friendly_name")
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * 
     * @param friendlyName
     *     The friendly_name
     */
    @JsonProperty("friendly_name")
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * 
     * @return
     *     The latestVersion
     */
    @JsonProperty("latest_version")
    public String getLatestVersion() {
        return latestVersion;
    }

    /**
     * 
     * @param latestVersion
     *     The latest_version
     */
    @JsonProperty("latest_version")
    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    /**
     * 
     * @return
     *     The fwOutdated
     */
    @JsonProperty("fw_outdated")
    public Boolean getFwOutdated() {
        return fwOutdated;
    }

    /**
     * 
     * @param fwOutdated
     *     The fw_outdated
     */
    @JsonProperty("fw_outdated")
    public void setFwOutdated(Boolean fwOutdated) {
        this.fwOutdated = fwOutdated;
    }

    /**
     * 
     * @return
     *     The intrusionSettings
     */
    @JsonProperty("intrusion_settings")
    public IntrusionSettings getIntrusionSettings() {
        return intrusionSettings;
    }

    /**
     * 
     * @param intrusionSettings
     *     The intrusion_settings
     */
    @JsonProperty("intrusion_settings")
    public void setIntrusionSettings(IntrusionSettings intrusionSettings) {
        this.intrusionSettings = intrusionSettings;
    }

    /**
     * 
     * @return
     *     The updatesAvailable
     */
    @JsonProperty("updates_available")
    public Boolean getUpdatesAvailable() {
        return updatesAvailable;
    }

    /**
     * 
     * @param updatesAvailable
     *     The updates_available
     */
    @JsonProperty("updates_available")
    public void setUpdatesAvailable(Boolean updatesAvailable) {
        this.updatesAvailable = updatesAvailable;
    }

    /**
     * 
     * @return
     *     The timezone
     */
    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    /**
     * 
     * @param timezone
     *     The timezone
     */
    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * 
     * @return
     *     The sensors
     */
    @JsonProperty("sensors")
    public List<Sensor> getSensors() {
        return sensors;
    }

    /**
     * 
     * @param sensors
     *     The sensors
     */
    @JsonProperty("sensors")
    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    /**
     * 
     * @return
     *     The firmwareStatus
     */
    @JsonProperty("firmware_status")
    public String getFirmwareStatus() {
        return firmwareStatus;
    }

    /**
     * 
     * @param firmwareStatus
     *     The firmware_status
     */
    @JsonProperty("firmware_status")
    public void setFirmwareStatus(String firmwareStatus) {
        this.firmwareStatus = firmwareStatus;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
