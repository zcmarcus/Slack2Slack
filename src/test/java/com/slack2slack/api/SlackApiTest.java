package com.slack2slack.api;

import org.junit.jupiter.api.Test;

public class SlackApiTest {

    @Test
    public void testCreateChannel() {
        // FIXME: Change to the 'Slack2Slack' Slack app for final version
        // You can find the bot token for 'SlacKerZ' app at this link
        // https://api.slack.com/apps/A011ARSEDGC/oauth?
        // This is just an easy way to test that the app is creating a channel for the time being
        SlackApi slackApi = new SlackApi("insert-private-token-here");
        slackApi.createChannel("kellytest");
    }
}
