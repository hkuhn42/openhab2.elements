/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements.api.cloud;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Endnode {

    private String status;
    @SerializedName("position_status")
    private String positionStatus;
    private Battery battery;
    @SerializedName("ts_button")
    private Long tsButton;
    @SerializedName("friendly_name")
    private String friendlyName;
    @SerializedName("latest_version")
    private String latestVersion;
    @SerializedName("fw_version")
    private String fwVersion;
    @SerializedName("firmware_status")
    private String firmwareStatus;
    private String type;
    private String id;

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
    public Battery getBattery() {
        return battery;
    }

    /**
     *
     * @param battery
     *            The battery
     */
    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    /**
     *
     * @return
     *         The tsButton
     */
    public Long getTsButton() {
        return tsButton;
    }

    /**
     *
     * @param tsButton
     *            The ts_button
     */
    public void setTsButton(Long tsButton) {
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
}
