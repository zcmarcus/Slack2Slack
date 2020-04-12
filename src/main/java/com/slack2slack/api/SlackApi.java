package com.slack2slack.api;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    }

    /**
     * Create channel.
     * https://api.slack.com/methods/conversations.create
     *
     * @param channelName the channel name. Channel names may only contain lowercase letters, numbers, hyphens, and underscores,
     * and must be 80 characters or less.
     */
    void createChannel(String channelName) {

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
