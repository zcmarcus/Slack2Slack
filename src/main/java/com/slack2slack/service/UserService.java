package com.slack2slack.service;

import com.slack2slack.entity.User;
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
 * This web service user-specific resources.
 */
@Path("/users")
public class UserService {

    /**
     * Produces response with all workspaces belonging to a user.
     */
    @GET
    @Produces("application/json")
    // Param is user id.
    @Path("/{param}")
    public Response getTemplates(@PathParam("param") int id) {
        JsonObject output = null;





        return Response.status(200).entity(output).build();

    }
}