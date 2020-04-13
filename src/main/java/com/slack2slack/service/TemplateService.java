package com.slack2slack.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.slack2slack.entity.*;
import com.slack2slack.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This web service provides a user with the ability to add, update, and
 * view saved Slack workspace and channel data in the form of workspace templates.
 */
@Path("/templates")
public class TemplateService {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao templateDao;

    /**
     * Produces response with all templates belonging to a given user.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // Param is user id.
    @Path("/{userID}")
    public Response getTemplates(@PathParam("userID") int userID) {
        JsonArrayBuilder templatesArray = Json.createArrayBuilder();

        templateDao = new GenericDao(Template.class);
        List<Template> templates = templateDao.getByPropertyEqual("user", userID);

        for (Template template: templates) {

            JsonObjectBuilder templateObject = Json.createObjectBuilder()
                    .add("templateId", template.getId())
                    .add("templateName", template.getName())
                    .add("iconUrl", template.getIconUrl())
                    .add("ownerFirstName", template.getOwnerFirstName())
                    .add("ownerLastName", template.getOwnerLastName())
                    .add("ownerDisplayName", template.getOwnerDisplayName())
                    .add("ownerEmail", template.getOwnerEmail());


        List<Channel> channels = template.getChannels();

        JsonArrayBuilder channelsArray = Json.createArrayBuilder();
        for (Channel channel : channels) {
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


        StringWriter stringWriter = new StringWriter();
        JsonWriter writer = Json.createWriter(stringWriter);
        writer.writeObject(allTemplatesObject);
        writer.close();
        logger.debug("stringWriter output of allTemplatesObject: {}", stringWriter.getBuffer().toString());

        return Response.status(200).entity(allTemplatesObject).build();

    }


    /**
     * Produces response with template matching supplied template ID.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // Param is user id.
    @Path("/template/{templateID}")
    public Response getTemplate(@PathParam("templateID") int id) {

        templateDao = new GenericDao(Template.class);
        Template template = (Template)templateDao.getById(id);
        logger.debug(template);

        // Read owner profile from JSON stored in database as String and convert to JsonNode object

        ObjectMapper mapper = new ObjectMapper();





        JsonObjectBuilder templateObject = Json.createObjectBuilder()
                .add("templateId", template.getId())
                .add("templateName", template.getName())
                .add("iconUrl", template.getIconUrl())
                .add("ownerFirstName", template.getOwnerFirstName())
                .add("ownerLastName", template.getOwnerLastName())
                .add("ownerDisplayName", template.getOwnerDisplayName())
                .add("ownerEmail", template.getOwnerEmail());


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


        logger.debug(templateObject);
        return Response.status(200).entity(templateObject.build()).build();

    }








//    /**
//     * Produces response with workspace details and all contained channels.
//     */
//    @GET
//    @Produces("text/plain")
//    // Param is workspace "id." This field and associated parameter will need to change in the future, likely
//    // to another unique identifier such a token.
//    @Path("/{param}")
//    public Response getWorkspaceDetailsAndChannels(@PathParam("param") int id) {
//        Channel week1Channel = new Channel();
//        week1Channel.setName("week-1");
//        week1Channel.setPurpose("Intro and discussion of Week 1 material");
//        week1Channel.setTopic("Upload first activity by end of week");
//        Channel week2Channel = new Channel();
//        week2Channel.setName("week-2");
//        week2Channel.setPurpose("Discussion of Week 2 material");
//        week2Channel.setTopic("Focus on variable scope");
//
//        ArrayList<Channel> channels = new ArrayList<>();
//        channels.add(week1Channel);
//        channels.add(week2Channel);
//
//        JsonObject profile = Json.createObjectBuilder()
//                .add("profile_details", Json.createArrayBuilder()
//                        .add(Json.createObjectBuilder()
//                                .add("first_name", "Anna")
//                                .add("last_name", "Smith")
//                                .add("display_name", "Bananas")
//                                .add("email", "asmith909@gmail.com")))
//                .build();
//
//        Template template = new Template();
//        template.setId(1);
//        template.setName("java-111");
//        template.setIconUrl("http://www.imgur.com/fakeimg.png");
//        template.setChannels(channels);
//        template.setPrimaryOwnerProfile(profile.toString());
//
//
////        String htmlOutput = "<h2>Template Details: </h2>";
//        String output = "Template Details: \n\n";
//        output = output + "Id: " + template.getId() + "\n\n"
//                + "Name: " + template.getName() + "\n\n"
//                + "IconUrl: " + template.getIconUrl() + "\n\n"
//                + "Primary Owner Profile (JSON data represented as string):" + template.getPrimaryOwnerProfile().toString()
//                + "\n\n"
//                + "****************************************************\n\n"
//                + "Template Channels: \n\n";
//        for(Channel channel : template.getChannels()) {
//            output = output + "Name: " + channel.getName() + "\n\n"
//                    + "Purpose: " + channel.getPurpose() + "\n\n"
//                    + "Topic: " + channel.getTopic() + "\n\n"
//                    + "*************************************************** \n\n";
//        }
//        return Response.status(200).entity(output).build();
//    }




}


