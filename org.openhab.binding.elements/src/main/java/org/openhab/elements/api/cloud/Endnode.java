
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
@JsonPropertyOrder({ "status", "position_status", "battery", "ts_button", "friendly_name", "latest_version",
        "fw_version", "firmware_status", "type", "id" })
public class Endnode {

    @JsonProperty("status")
    private String status;
    @JsonProperty("position_status")
    private String positionStatus;
    @JsonProperty("battery")
    private Battery battery;
    @JsonProperty("ts_button")
    private Long tsButton;
    @JsonProperty("friendly_name")
    private String friendlyName;
    @JsonProperty("latest_version")
    private String latestVersion;
    @JsonProperty("fw_version")
    private String fwVersion;
    @JsonProperty("firmware_status")
    private String firmwareStatus;
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *            The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     *         The positionStatus
     */
    @JsonProperty("position_status")
    public String getPositionStatus() {
        return positionStatus;
    }

    /**
     *
     * @param positionStatus
     *            The position_status
     */
    @JsonProperty("position_status")
    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
    }

    /**
     *
     * @return
     *         The battery
     */
    @JsonProperty("battery")
    public Battery getBattery() {
        return battery;
    }

    /**
     *
     * @param battery
     *            The battery
     */
    @JsonProperty("battery")
    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    /**
     *
     * @return
     *         The tsButton
     */
    @JsonProperty("ts_button")
    public Long getTsButton() {
        return tsButton;
    }

    /**
     *
     * @param tsButton
     *            The ts_button
     */
    @JsonProperty("ts_button")
    public void setTsButton(Long tsButton) {
        this.tsButton = tsButton;
    }

    /**
     *
     * @return
     *         The friendlyName
     */
    @JsonProperty("friendly_name")
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     *
     * @param friendlyName
     *            The friendly_name
     */
    @JsonProperty("friendly_name")
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     *
     * @return
     *         The latestVersion
     */
    @JsonProperty("latest_version")
    public String getLatestVersion() {
        return latestVersion;
    }

    /**
     *
     * @param latestVersion
     *            The latest_version
     */
    @JsonProperty("latest_version")
    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    /**
     *
     * @return
     *         The fwVersion
     */
    @JsonProperty("fw_version")
    public String getFwVersion() {
        return fwVersion;
    }

    /**
     *
     * @param fwVersion
     *            The fw_version
     */
    @JsonProperty("fw_version")
    public void setFwVersion(String fwVersion) {
        this.fwVersion = fwVersion;
    }

    /**
     *
     * @return
     *         The firmwareStatus
     */
    @JsonProperty("firmware_status")
    public String getFirmwareStatus() {
        return firmwareStatus;
    }

    /**
     *
     * @param firmwareStatus
     *            The firmware_status
     */
    @JsonProperty("firmware_status")
    public void setFirmwareStatus(String firmwareStatus) {
        this.firmwareStatus = firmwareStatus;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
