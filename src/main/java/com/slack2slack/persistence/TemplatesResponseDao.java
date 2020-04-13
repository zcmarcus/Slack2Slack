package com.slack2slack.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.slack2slack.consume.TemplateItem;
import com.slack2slack.consume.TemplatesCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class TemplatesResponseDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public TemplatesCollection getTemplates(int userID ) {
        Client client = ClientBuilder.newClient();
//        logger.debug("user ID: {}", userID);
        WebTarget target =
                client.target("http://localhost:8080/Slack2Slack_war/service/templates/" // TODO: remove hard-coded values
                        + userID);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
//        logger.debug("response: {}", response);

        ObjectMapper mapper = new ObjectMapper();
        TemplatesCollection retrievedTemplates = null;
        try {
            retrievedTemplates = mapper.readValue(response, TemplatesCollection.class);
        } catch (JsonProcessingException e) {
            logger.error("Encountered a problem processing JSON: {}", e);
        }
//        logger.debug(retrievedTemplates);

        return retrievedTemplates;
    }

    public TemplateItem getTemplateByID(int templateId ) {
        Client client = ClientBuilder.newClient();
//        logger.debug("template ID: {}", templateId);
        WebTarget target =
                client.target("http://localhost:8080/Slack2Slack_war/service/templates/template/" // TODO: remove hard-coded values
                        + templateId);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
//        logger.debug("response: {}", response);
        ObjectMapper mapper = new ObjectMapper();
        TemplateItem retrievedTemplate = null;
        try {
            retrievedTemplate = mapper.readValue(response, TemplateItem.class);
        } catch (JsonProcessingException e) {
            logger.error("Encountered a problem processing JSON: {}", e);
        }
        return retrievedTemplate;
    }
}