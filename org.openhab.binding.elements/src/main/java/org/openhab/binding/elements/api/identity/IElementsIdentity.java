/**
 *
 */
package org.openhab.binding.elements.api.identity;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author hkuhn
 *
 */
public interface IElementsIdentity {

    public static final String CLOUD_URL = "https://im.gigaset-elements.de";

    /**
     * https://im.gigaset-elements.de
     *
     * @param username
     * @param password
     */
    @POST
    @Path("/identity/api/v1/user/login")
    public IdentitiyResult login(@FormParam("email") String username, @FormParam("password") String password);

    /**
     * https://im.gigaset-elements.de
     *
     * @param username
     * @param password
     */
    @POST
    @Path("/identity/api/v1/user/login")
    public String loginProto(@FormParam("email") String username, @FormParam("password") String password);
}
