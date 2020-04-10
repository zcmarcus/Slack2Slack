package com.slack2slack.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack2slack.entity.Channel;
import com.slack2slack.entity.Template;
import com.slack2slack.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * This web service provides a user with the ability to add, update, and
 * view saved Slack workspace and channel data.
 */
@Path("/templates")
public class TemplateService {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao templateDao;

    /**
     * Produces response with all workspaces belonging to a given user.
     */
    @GET
    @Produces("application/json")
    // Param is user id.
    @Path("/{param}")
    public Response getTemplates(@PathParam("param") int userID) {
        JsonArrayBuilder templatesArray = Json.createArrayBuilder();

        templateDao = new GenericDao(Template.class);
        List<Template> templates = templateDao.getByPropertyEqual("user", userID);
        logger.debug(templates);
        // Read owner profile from JSON stored in database as String and convert to JsonNode object
        for (Template template: templates) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode ownerProfileNode = null;
            String ownerFirstName = "";
            String ownerLastName = "";
            String ownerDisplayName = "";
            String ownerEmail = "";
            try {
                ownerProfileNode = mapper.readTree(template.getPrimaryOwnerProfile());
                ownerFirstName = ownerProfileNode.get("first_name").asText();
                ownerLastName = ownerProfileNode.get("last_name").asText();
                ownerDisplayName = ownerProfileNode.get("display_name").asText();
                ownerEmail = ownerProfileNode.get("email").asText();

            } catch (JsonProcessingException e) {
                logger.error("Error reading JSON from string");
            }

            JsonObjectBuilder templateObject = Json.createObjectBuilder()
                    .add("templateName", template.getName())
                    .add("iconUrl", template.getIconUrl())
                    .add("primaryOwnerProfile", Json.createObjectBuilder()
                        .add("firstName", ownerFirstName)
                        .add("lastName", ownerLastName)
                        .add("displayName", ownerDisplayName)
                        .add("email", ownerEmail)
                    );

            List<Channel> channels = template.getChannels();

            JsonArrayBuilder channelsArray = Json.createArrayBuilder();
            for (Channel channel: channels) {
                JsonObjectBuilder channelObject = Json.createObjectBuilder()
                        .add("name", channel.getName())
                        .add("purpose", channel.getPurpose())
                        .add("topic", channel.getTopic());

                // Add channel to channels array
                channelsArray
                        .add(channelObject);
            }

            // Add channels array to template JSON object
            templateObject
                    .add("channels", channelsArray);

            // Add template JSON object to array of templates
            templatesArray
                    .add(templateObject);


        }

        // Nest template JSON objects within allTemplatesObject
        JsonObject allTemplatesObject = Json.createObjectBuilder()
                .add("templates", templatesArray)
                .build();

        logger.debug(allTemplatesObject);

        return Response.status(200).entity(allTemplatesObject).build();

    }








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
        template.setPrimaryOwnerProfile(profile.toString());


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


