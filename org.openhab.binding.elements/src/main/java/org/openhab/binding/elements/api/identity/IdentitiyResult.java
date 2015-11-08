
package org.openhab.binding.elements.api.identity;

import java.util.HashMap;
import java.util.Map;

public class IdentitiyResult {

    private Integer http;
    private Integer code;
    private String status;
    private String message;
    private String reefssid;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getHttp() {
        return http;
    }

    public void setHttp(Integer http) {
        this.http = http;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReefssid() {
        return reefssid;
    }

    public void setReefssid(String reefssid) {
        this.reefssid = reefssid;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
}