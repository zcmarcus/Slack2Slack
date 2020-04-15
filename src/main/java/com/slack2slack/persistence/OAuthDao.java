package com.slack2slack.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack2slack.api.OAuthResponse;
import com.slack2slack.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

/**
 * This DAO obtains OAuth information from the Slack API
 */
public class OAuthDao implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Accesses the oauth.v2.access method of the Slack API and returns the API's response
     * @param tempSlackCode the temporary Slack authentication code that must be exchanged for an access code
     * @return response from OAuth
     */
    public OAuthResponse getOAuthResponse(String tempSlackCode) {
        String oAuthAccessMethod = "";
        String client_id = "";
        String client_secret = "";

        //Load the Slack authentication properties from the properties file
        try {
            Properties properties = loadProperties("/slack.secrets.properties");
            oAuthAccessMethod = properties.getProperty("oAuthAccessMethod");
            client_id = properties.getProperty("clientId");
            client_secret = properties.getProperty("clientSecret");
        } catch (IOException io) {
            logger.debug("There was a problem reading the properties: " + io);
        } catch (Exception e) {
            logger.debug("Encountered a problem: " + e);
        }

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(oAuthAccessMethod + "?code=" + tempSlackCode + "&client_id=" + client_id + "&client_secret=" + client_secret);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        OAuthResponse oAuthResponse = null;
        try {
            oAuthResponse = mapper.readValue(response, OAuthResponse.class);
        } catch (JsonProcessingException e) {
            logger.error("Encountered a problem processing JSON in OAuthDao", e);
        }

        return oAuthResponse;
    }
}
