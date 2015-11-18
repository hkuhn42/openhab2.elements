/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements.api.cloud;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Encapsulates the user api (for webapp and )
 *
 * @author hkuhn
 *
 */
public interface IElementsUserApi {

    public static final String CLOUD_URL = "https://api.gigaset-elements.de";

    /**
     * @param op always gigaset
     */
    @GET
    @Path("/api/v1/auth/openid/begin")
    public Response connect(@QueryParam("op") String op, @CookieParam("reefssid") String reefssid);

    /**
     * List all basestations
     *
     * @return array of Base
     */
    @GET
    @Path("/api/v1/me/basestations")
    public Base[] getBase(@CookieParam("usertoken") String usertoken);

    /**
     * Fetching events
     *
     * @return EventResult object
     */
    @GET
    @Path("/api/v1/me/events")
    public EventResult getEvents(@QueryParam("limit") Integer limit, @CookieParam("usertoken") String usertoken);

    /**
     * Sets the basestation intrusion mode
     *
     * @return
     */
    @POST
    @Path("/api/v1/me/basestations/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public String setIntrusionSettings(@PathParam("id") String id, @CookieParam("usertoken") String usertoken,
            BaseConfig mode);
}