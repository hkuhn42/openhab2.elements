/**
 *
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
 * private static final String url02 = "https://api.gigaset-elements.de";
 *
 * @author hkuhn
 *
 */
public interface IElementsClient {

    public static final String CLOUD_URL = "https://api.gigaset-elements.de";

    /**
     * @param op always gigaset
     */
    @GET
    @Path("/api/v1/auth/openid/begin")
    public Response connect(@QueryParam("op") String op, @CookieParam("reefssid") String reefssid);

    /**
     *
     *
     * @return
     */
    @GET
    @Path("/api/v1/me/basestations")
    public Base[] getBase(@CookieParam("usertoken") String usertoken);

    /**
     *
     * @return
     */
    @GET
    @Path("/api/v1/me/events")
    public EventResult getEvents(@QueryParam("limit") Integer limit, @CookieParam("usertoken") String usertoken);

    /**
     *
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