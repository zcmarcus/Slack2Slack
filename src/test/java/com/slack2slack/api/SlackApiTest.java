package com.slack2slack.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack.api.*;
import com.slack2slack.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Properties;

public class SlackApiTest implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties slackApiProperties;

    @BeforeEach
    public void setup() {
        try {
            slackApiProperties = loadProperties("/slack.api.properties");

        } catch (IOException io) {
            logger.debug("There was a problem reading the file: " + io);
        } catch (Exception e) {
            logger.debug("Encountered a problem: " + e);
        }

    }

    @Test
    public void testCreateChannel() {
        // FIXME: Change to the 'Slack2Slack' Slack app for final version
        // You can find the bot token for 'SlacKerZ' app at this link
        // https://api.slack.com/apps/A011ARSEDGC/oauth?
        // This is just an easy way to test that the app is creating a channel for the time being
        SlackApi slackApi = new SlackApi(slackApiProperties.getProperty("botuser.oauth.accesstoken"));
        String newChannel = "newTestChannel";
        slackApi.createChannel(newChannel);
        // TODO: assertion to check that channel was successffuly created
        ObjectMapper mapper = new ObjectMapper();
        PublicChannelsResponse = mapper.readValue(slackApi.getChannelsList();




        try {
            slackApiProperties = loadProperties("/slack.api.properties");
        } catch (IOException io) {
            logger.debug("There was a problem reading the file: " + io);
        } catch (Exception e) {
            logger.debug("Encountered a problem: " + e);
        }

        CreateConversationParameters parameters = new CreateConversationParameters();
        parameters.setName(channelName);


        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(slackApiProperties.getProperty("create.conversation.target"));
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .header("Content-type", "application/json")
                .post(Entity.json(parameters));

        //TODO Request works but we still need to do something with the response.

    }
}
