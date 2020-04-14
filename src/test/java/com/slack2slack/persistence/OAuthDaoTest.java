package com.slack2slack.persistence;

import com.slack2slack.util.PropertiesLoader;
import org.junit.jupiter.api.Test;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Properties;

/*
* //TODO: JAVADOC
 */
public class OAuthDaoTest implements PropertiesLoader {
    @Test
    void getSlackUserTokenSuccess() throws Exception {
        String oAuthAccessMethod = "";
        //For testing purposes, you can get the temp code after logging into our Slack2Slack app and then grabbing the code parameter from the URL
        //It expires after 10 minutes
        String tempSlackCode = "";
        String client_id = "";
        String client_secret = "";

        //Load the Slack authentication properties from the properties file
        try {
            Properties properties = loadProperties("/slack.secrets.properties");
            oAuthAccessMethod = properties.getProperty("oAuthAccessMethod");
            client_id = properties.getProperty("clientID");
            client_secret = properties.getProperty("clientSecret");
        } catch (Exception e) {
            e.printStackTrace();
        }


        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(oAuthAccessMethod + "?code=" + tempSlackCode + "&client_id=" + client_id + "&client_secret=" + client_secret);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("???", response);
    }
}
