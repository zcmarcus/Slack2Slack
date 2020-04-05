package com.slack2slack.service;

import com.slack2slack.entity.Channel;
import com.slack2slack.entity.Template;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * This web service provides a user with the ability to add, update, and
 * view saved Slack workspace and channel data.
 */
@Path("/workspaces")
public class WorkspaceService {
    /**
     * Produces response with workspace details and all contained channels.
     */
    @GET
    @Produces("text/plain")
    // Param is workspace "id." This field and associated parameter will need to change in the future, likely
    // to another unique identifier such a token.
    @Path("/{param}")
    public Response getWorkspaceDetailsAndChannels(@PathParam("param") int id) {
        Channel week1Channel = new Channel();
        week1Channel.setName("week-1");
        week1Channel.setPurpose("Intro and discussion of Week 1 material");
        week1Channel.setTopic("Upload first activity by end of week");
        Channel week2Channel = new Channel();
        week2Channel.setName("week-2");
        week2Channel.setPurpose("Discussion of Week 2 material");
        week2Channel.setTopic("Focus on variable scope");

        ArrayList<Channel> channels = new ArrayList<>();
        channels.add(week1Channel);
        channels.add(week2Channel);

        JsonObject profile = Json.createObjectBuilder()
                .add("profile_details", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("first_name", "Anna")
                                .add("last_name", "Smith")
                                .add("display_name", "Bananas")
                                .add("email", "asmith909@gmail.com")))
                .build();

        Template template = new Template();
        template.setId(1);
        template.setName("java-111");
        template.setIconUrl("http://www.imgur.com/fakeimg.png");
        template.setChannels(channels);
        template.setPrimaryOwnerProfile(profile);


//        String htmlOutput = "<h2>Template Details: </h2>";
        String output = "Template Details: \n\n";
        output = output + "Id: " + template.getId() + "\n\n"
                + "Name: " + template.getName() + "\n\n"
                + "IconUrl: " + template.getIconUrl() + "\n\n"
                + "Primary Owner Profile (JSON data represented as string):" + template.getPrimaryOwnerProfile().toString()
                + "\n\n"
                + "****************************************************\n\n"
                + "Template Channels: \n\n";
        for(Channel channel : template.getChannels()) {
            output = output + "Name: " + channel.getName() + "\n\n"
                    + "Purpose: " + channel.getPurpose() + "\n\n"
                    + "Topic: " + channel.getTopic() + "\n\n"
                    + "*************************************************** \n\n";
        }
        return Response.status(200).entity(output).build();
    }
}
