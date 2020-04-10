package com.slack2slack.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.slack2slack.consume.TemplatesResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class TemplatesResponseDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public TemplatesResponse getTemplates(int userID ) {
        Client client = ClientBuilder.newClient();
        logger.debug("user ID: {}", userID);
        WebTarget target =
                client.target("http://localhost:8080/slack2slack/service/templates/" // TODO: remove hard-coded values
                        + userID);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.debug(response);
        ObjectMapper mapper = new ObjectMapper();
        TemplatesResponse retrievedTemplates = null;
        try {
            retrievedTemplates = mapper.readValue(response, TemplatesResponse.class);
        } catch (JsonProcessingException e) {
            logger.error("Encountered a problem processing JSON: {}", e);
        }
        return retrievedTemplates;
    }

}