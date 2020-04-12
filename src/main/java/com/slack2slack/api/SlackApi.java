package com.slack2slack.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack.api.PublicChannelsResponse;
import com.slack2slack.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Slack api. channel
 */
public class SlackApi implements PropertiesLoader {

    /**
     * The Token.
     */
    String token;
    Properties slackApiProperties;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Instantiates a new Slack api.
     *
     * @param token the bot token associated with our slack app
     */
    public SlackApi(String token) {
        this.token = token;
        try {
            slackApiProperties = loadProperties("/slack.api.properties");
        } catch (IOException io) {
            logger.debug("There was a problem reading the file: " + io);
        } catch (Exception e) {
            logger.debug("Encountered a problem: " + e);
        }
    }

    /**
     * Create channel.
     * https://api.slack.com/methods/conversations.create
     *
     * @param channelName the channel name. Channel names may only contain lowercase letters, numbers, hyphens, and underscores,
     * and must be 80 characters or less.
     */
    public Response createChannel(String channelName) {

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

        logger.debug(response);
        //TODO Request works but we still need to do something with the response.
        return response;

    }


    public PublicChannelsResponse getChannels() {

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(slackApiProperties.getProperty("conversations.list.target") + "?token=" + token);
        String response = target
                .request().get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        PublicChannelsResponse publicChannelsResponse = null;
        try {
            publicChannelsResponse = mapper.readValue(response, PublicChannelsResponse.class);
        } catch (JsonProcessingException e) {
            logger.error("Error processing response as JSON");
            logger.error(e);
        }
        logger.debug(response);
        return publicChannelsResponse;

    }
}
