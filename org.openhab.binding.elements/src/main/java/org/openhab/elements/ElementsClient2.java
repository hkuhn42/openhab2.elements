/**
 *
 */
package org.openhab.elements;

import java.util.Collection;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.filter.LoggingFilter;
import org.openhab.binding.elements.api.cloud.Base;
import org.openhab.binding.elements.api.cloud.IElementsClient;
import org.openhab.binding.elements.api.identity.IElementsIdentity;
import org.openhab.binding.elements.api.identity.IdentitiyResult;

/**
 * @author hkuhn
 *
 */
public class ElementsClient2 {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        ElementsClient2 client = new ElementsClient2();

        try {
            String usertoken = "_5iDhdFYTsKGFah9wyoMCg__TIMESTAMP__1447002476:1ZvMtA:UpVfp3mLOUnYzrLrSXFJW1FLiaQ";
            client.getBase(usertoken);
        } catch (NotAuthorizedException e) {
            IdentitiyResult identifity = client.getIdString("harald.kuhn@gmail.com", "xaZmZP@hJ59DD");
            System.out.println("reefssid:" + identifity.getReefssid());

            String usertoken = client.getUserToken(identifity.getReefssid());
            System.out.println("usertoken:" + usertoken);

            client.getBase(usertoken);
        }

    }

    public IdentitiyResult getIdString(String email, String passwd) throws Exception {
        ClientConfig conf = new ClientConfig();
        Client client = ClientBuilder.newClient(conf);
        client.register(LoggingFilter.class);
        WebTarget target = client.target(IElementsIdentity.CLOUD_URL);

        IElementsIdentity elementsCloud = WebResourceFactory.newResource(IElementsIdentity.class, target);

        return elementsCloud.login(email, passwd);
    }

    public String getUserToken(String reefssid) throws Exception {
        ClientConfig conf = new ClientConfig();
        Client client = ClientBuilder.newClient(conf);
        client.register(LoggingFilter.class);

        // client.register(LoggingFilter.class);

        WebTarget t = client.target(IElementsClient.CLOUD_URL);

        // create a new client proxy for the BooksResource
        IElementsClient elementsCloud = WebResourceFactory.newResource(IElementsClient.class, t);

        Response response = elementsCloud.connect("gigaset", reefssid);
        Cookie usercookie = response.getCookies().get("usertoken");
        return usercookie.getValue();
    }

    public void getBase(String usertoken) throws NotAuthorizedException {
        ClientConfig conf = new ClientConfig();
        Client client = ClientBuilder.newClient(conf);
        client.register(LoggingFilter.class);
        // client.register(JSON2PojoFeature.class);

        WebTarget t = client.target(IElementsClient.CLOUD_URL);
        IElementsClient elementsCloud = WebResourceFactory.newResource(IElementsClient.class, t);

        Collection<Base> baseData = elementsCloud.getBase(usertoken);
        System.out.println(baseData.size());
    }

}
