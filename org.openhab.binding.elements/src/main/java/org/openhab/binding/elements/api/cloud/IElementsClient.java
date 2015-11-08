/**
 *
 */
package org.openhab.binding.elements.api.cloud;

import java.util.Collection;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    public Collection<Base> getBase(@CookieParam("usertoken") String usertoken);

    /**
     *
     * @return
     */
    @GET
    @Path("/api/v1/me/events")
    public String getEvents(@QueryParam("limit") Integer limit, @CookieParam("usertoken") String usertoken);
}