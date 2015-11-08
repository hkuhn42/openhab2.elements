
package org.openhab.binding.elements.api.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Mode {

    private Home home;
    private Away away;
    private Custom custom;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *         The home
     */
    public Home getHome() {
        return home;
    }

    /**
     *
     * @param home
     *            The home
     */
    public void setHome(Home home) {
        this.home = home;
    }

    /**
     *
     * @return
     *         The away
     */
    public Away getAway() {
        return away;
    }

    /**
     *
     * @param away
     *            The away
     */
    public void setAway(Away away) {
        this.away = away;
    }

    /**
     *
     * @return
     *         The custom
     */
    public Custom getCustom() {
        return custom;
    }

    /**
     *
     * @param custom
     *            The custom
     */
    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
