package com.slack2slack.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The type Slack api.
 */
public class SlackApi {

    /**
     * The Token.
     */
    String token;

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
        CreateConversationParameters parameters = new CreateConversationParameters();
        parameters.setName(channelName);


        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://slack.com/api/conversations.create");
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .header("Content-type", "application/json")
                .post(Entity.json(parameters));

        //TODO Request works but we still need to do something with the response.

    }
}
