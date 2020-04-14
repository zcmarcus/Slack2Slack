package com.slack2slack.persistence;

import org.junit.jupiter.api.Test;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/*
* //TODO: JAVADOC
 */
public class OAuthDaoTest {
    @Test
    void getSlackUserTokenSuccess() throws Exception {
        String baseURL = "https://slack.com/api/oauth.v2.access?code=";
        //For testing purposes, you can get this after logging into our Slack2Slack app and then grabbing the code parameter from the URL
        String tempSlackCode = "1025804317248.1059683487554.1e220b48d546805b00304853c2afd2908cad110645cfa2bf8573dbe48d0cd292";
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(baseURL + tempSlackCode);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("???", response);
    }
}
