package com.cc.gigaset.jersey;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import com.cc.gigaset.common.GigasetElementsBase;
import com.cc.gigaset.common.Listener;

public class GigasetElementsJersey extends GigasetElementsBase {

    public GigasetElementsJersey(String username, String password, List<Listener> listeners) {
        super(username, password, listeners);
    }

    public GigasetElementsJersey(String username, String password) {
        super(username, password);
    }

    @Override
    protected Client newClient() {
        ClientConfig config = new ClientConfig();
        config.property(ClientProperties.FOLLOW_REDIRECTS, true);
        Client client = ClientBuilder.newClient(config);

        // LoggingFilter component = new LoggingFilter(Logger.getLogger(LoggingFilter.class.getName()), true);
        // client.register(component);
        return client;
    }
}
