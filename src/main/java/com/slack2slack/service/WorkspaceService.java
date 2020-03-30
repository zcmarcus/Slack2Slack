package com.slack2slack.service;

import com.slack2slack.entity.Channel;
import com.slack2slack.entity.Workspace;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/workspaces")
public class WorkspaceService {
    @GET
    @Produces("text/plain")
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

        Workspace workspace = new Workspace();
        workspace.setId(1);
        workspace.setName("java-111");
        workspace.setIconUrl("http://www.imgur.com/fakeimg.png");
        workspace.setChannels(channels);
        workspace.setPrimaryOwnerProfile(profile);


//        String htmlOutput = "<h2>Workspace Details: </h2>";
        String output = "Workspace Details: \n\n";
        output = output + "Id: " + workspace.getId() + "\n\n"
                + "Name: " + workspace.getName() + "\n\n"
                + "IconUrl: " + workspace.getIconUrl() + "\n\n"
                + "Primary Owner Profile (JSON data represented as string):" + workspace.getPrimaryOwnerProfile().toString()
                + "\n\n"
                + "****************************************************\n\n"
                + "Workspace Channels: \n\n";
        for(Channel channel : workspace.getChannels()) {
            output = output + "Name: " + channel.getName() + "\n\n"
                    + "Purpose: " + channel.getPurpose() + "\n\n"
                    + "Topic: " + channel.getTopic() + "\n\n"
                    + "*************************************************** \n\n";
        }
        return Response.status(200).entity(output).build();
    }
}
