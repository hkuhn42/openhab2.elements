
package org.openhab.binding.elements.api.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Sensor {

    private String status;
    private String positionStatus;
    private Battery_ battery;
    private Integer tsButton;
    private String friendlyName;
    private String latestVersion;
    private String fwVersion;
    private String firmwareStatus;
    private String type;
    private String id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *            The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     *         The positionStatus
     */
    public String getPositionStatus() {
        return positionStatus;
    }

    /**
     *
     * @param positionStatus
     *            The position_status
     */
    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
    }

    /**
     *
     * @return
     *         The battery
     */
    public Battery_ getBattery() {
        return battery;
    }

    /**
     *
     * @param battery
     *            The battery
     */
    public void setBattery(Battery_ battery) {
        this.battery = battery;
    }

    /**
     *
     * @return
     *         The tsButton
     */
    public Integer getTsButton() {
        return tsButton;
    }

    /**
     *
     * @param tsButton
     *            The ts_button
     */
    public void setTsButton(Integer tsButton) {
        this.tsButton = tsButton;
    }

    /**
     *
     * @return
     *         The friendlyName
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     *
     * @param friendlyName
     *            The friendly_name
     */
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     *
     * @return
     *         The latestVersion
     */
    public String getLatestVersion() {
        return latestVersion;
    }

    /**
     *
     * @param latestVersion
     *            The latest_version
     */
    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    /**
     *
     * @return
     *         The fwVersion
     */
    public String getFwVersion() {
        return fwVersion;
    }

    /**
     *
     * @param fwVersion
     *            The fw_version
     */
    public void setFwVersion(String fwVersion) {
        this.fwVersion = fwVersion;
    }

    /**
     *
     * @return
     *         The firmwareStatus
     */
    public String getFirmwareStatus() {
        return firmwareStatus;
    }

    /**
     *
     * @param firmwareStatus
     *            The firmware_status
     */
    public void setFirmwareStatus(String firmwareStatus) {
        this.firmwareStatus = firmwareStatus;
    }

    /**
     *
     * @return
     *         The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *            The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *         The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *            The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
