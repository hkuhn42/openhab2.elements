/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements.api.cloud;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Base {

    private String status;
    private String version;
    private List<Endnode> endnodes = new ArrayList<Endnode>();
    @SerializedName("friendly_name")
    private String friendlyName;
    @SerializedName("latest_version")
    private String latestVersion;
    @SerializedName("fw_outdated")
    private Boolean fwOutdated;
    @SerializedName("intrusion_settings")
    private IntrusionSettings intrusionSettings;
    @SerializedName("updates_available")
    private Boolean updatesAvailable;
    private String timezone;
    private List<Sensor> sensors = new ArrayList<Sensor>();
    @SerializedName("firmware_status")
    private String firmwareStatus;
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
     *         The version
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version
     *            The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     *
     * @return
     *         The endnodes
     */
    public List<Endnode> getEndnodes() {
        return endnodes;
    }

    /**
     *
     * @param endnodes
     *            The endnodes
     */
    public void setEndnodes(List<Endnode> endnodes) {
        this.endnodes = endnodes;
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
     *         The fwOutdated
     */
    public Boolean getFwOutdated() {
        return fwOutdated;
    }

    /**
     *
     * @param fwOutdated
     *            The fw_outdated
     */
    public void setFwOutdated(Boolean fwOutdated) {
        this.fwOutdated = fwOutdated;
    }

    /**
     *
     * @return
     *         The intrusionSettings
     */
    public IntrusionSettings getIntrusionSettings() {
        return intrusionSettings;
    }

    /**
     *
     * @param intrusionSettings
     *            The intrusion_settings
     */
    public void setIntrusionSettings(IntrusionSettings intrusionSettings) {
        this.intrusionSettings = intrusionSettings;
    }

    /**
     *
     * @return
     *         The updatesAvailable
     */
    public Boolean getUpdatesAvailable() {
        return updatesAvailable;
    }

    /**
     *
     * @param updatesAvailable
     *            The updates_available
     */
    public void setUpdatesAvailable(Boolean updatesAvailable) {
        this.updatesAvailable = updatesAvailable;
    }

    /**
     *
     * @return
     *         The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     *
     * @param timezone
     *            The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     *
     * @return
     *         The sensors
     */
    public List<Sensor> getSensors() {
        return sensors;
    }

    /**
     *
     * @param sensors
     *            The sensors
     */
    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
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
