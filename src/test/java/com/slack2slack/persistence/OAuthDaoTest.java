package com.slack2slack.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack2slack.api.OAuthResponse;
import com.slack2slack.util.PropertiesLoader;
import org.junit.jupiter.api.Test;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Properties;

/*
* //TODO: JAVADOC
 */
public class OAuthDaoTest implements PropertiesLoader {
    @Test
    //TODO: This is actually testing that the app_id in the response is as expected, since the app_id is a static parameter
    void getSlackUserTokenSuccess() throws Exception {
        OAuthDao dao = new OAuthDao();

        String expectedApp_id = "";

        //Load the Slack authentication properties from the properties file
        try {
            Properties properties = loadProperties("/slack.secrets.properties");
            expectedApp_id = properties.getProperty("appId");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //IMPORTANT: Temporary slack code is generated after logging into Slack2Slack. You can find it in the url. It expires after 10 minutes.
        assertTrue(dao.getOAuthResponse("").isOk());
        assertEquals(expectedApp_id, dao.getOAuthResponse("").getAppId());
    }
}
