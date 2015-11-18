/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements.api.identity;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Identity serivce for authentication
 *
 * @author hkuhn
 */
public interface IElementsIdentityApi {

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
}
