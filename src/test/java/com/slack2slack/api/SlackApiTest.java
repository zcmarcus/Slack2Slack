package com.slack2slack.api;

import org.junit.jupiter.api.Test;

public class SlackApiTest {

    @Test
    public void testCreateChannel() {
        // You can find the token at this link
        // https://api.slack.com/apps/A010PV5TP6D/oauth?
        // This is just an easy way to test that the app is creating a channel for the time being
        SlackApi slackApi = new SlackApi("insert-token-here");
        slackApi.createChannel("sarahtest");

    }
}
