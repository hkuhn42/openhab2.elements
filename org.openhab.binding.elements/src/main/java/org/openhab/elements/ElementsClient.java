/**
 * Copyright (c) 2015 Harald Kuhn
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.elements;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.openhab.elements.api.cloud.Base;
import org.openhab.elements.api.cloud.BaseConfig;
import org.openhab.elements.api.cloud.EventResult;
import org.openhab.elements.api.cloud.IElementsUserApi;
import org.openhab.elements.api.cloud.IntrusionSettings;
import org.openhab.elements.api.identity.IElementsIdentityApi;
import org.openhab.elements.api.identity.IdentitiyResult;

import com.eclipsesource.jaxrs.provider.gson.GsonProvider;

/**
 * Cloud Client wrapper
 *
 * @author hkuhn
 */
public class ElementsClient {

    private Client client;

    // public ElementsClient() {
    // ClientConfig conf = new ClientConfig();
    // client = ClientBuilder.newClient(conf);
    // client.register(JacksonFeature.class);
    // }

    public ElementsClient() {
        ClientConfig conf = new ClientConfig();
        client = ClientBuilder.newClient(conf);
        client.register(new GsonProvider<Object>());
    }

    public Client getServiceClient() {
        return client;
    }

    /**
     * PUBLIC API
     *
     * @param email
     * @param passwd
     * @return
     * @throws Exception
     */
    public String getUserToken(String email, String passwd) throws Exception {
        IdentitiyResult identifity = getIdString(email, passwd);
        return getUserToken(identifity.getReefssid());
    }

    public IdentitiyResult getIdString(String email, String passwd) throws Exception {

        WebTarget target = client.target(IElementsIdentityApi.CLOUD_URL);

        IElementsIdentityApi elementsCloud = WebResourceFactory.newResource(IElementsIdentityApi.class, target);

        return elementsCloud.login(email, passwd);
    }

    public String getUserToken(String reefssid) throws Exception {
        WebTarget target = client.target(IElementsUserApi.CLOUD_URL);

        // create a new client proxy for the BooksResource
        IElementsUserApi elementsCloud = WebResourceFactory.newResource(IElementsUserApi.class, target);

        Response response = elementsCloud.connect("gigaset", reefssid);
        Cookie usercookie = response.getCookies().get("usertoken");
        return usercookie.getValue();
    }

    /**
     * public api
     *
     * @param usertoken
     * @return
     * @throws NotAuthorizedException
     */
    public Base[] getBase(String usertoken) throws NotAuthorizedException {
        WebTarget target = client.target(IElementsUserApi.CLOUD_URL);
        IElementsUserApi elementsCloud = WebResourceFactory.newResource(IElementsUserApi.class, target);

        return elementsCloud.getBase(usertoken);
    }

    public void setMode(String baseId, String mode, String usertoken) {
        WebTarget target = client.target(IElementsUserApi.CLOUD_URL);
        IElementsUserApi elementsCloud = WebResourceFactory.newResource(IElementsUserApi.class, target);
        IntrusionSettings settings = new IntrusionSettings();
        settings.setActiveMode(mode.toLowerCase());

        BaseConfig config = new BaseConfig();
        config.setIntrusionSettings(settings);

        elementsCloud.setIntrusionSettings(baseId, usertoken, config);
    }

    public EventResult getEvents(String usertoken) {
        WebTarget target = client.target(IElementsUserApi.CLOUD_URL);
        IElementsUserApi elementsCloud = WebResourceFactory.newResource(IElementsUserApi.class, target);

        return elementsCloud.getEvents(5, usertoken);
    }
}
