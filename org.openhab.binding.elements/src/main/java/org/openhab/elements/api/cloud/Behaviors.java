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

@Generated("org.jsonschema2pojo")
public class Behaviors {

    private String tilt;
    private String open;

    /**
     *
     * @return
     *         The tilt
     */
    public String getTilt() {
        return tilt;
    }

    /**
     *
     * @param tilt
     *            The tilt
     */
    public void setTilt(String tilt) {
        this.tilt = tilt;
    }

    /**
     *
     * @return
     *         The open
     */
    public String getOpen() {
        return open;
    }

    /**
     *
     * @param open
     *            The open
     */
    public void setOpen(String open) {
        this.open = open;
    }

}
