package com.slack2slack.entity;

import javax.json.JsonObject;
import java.util.ArrayList;

public class Template {

    private int id; // Identifier is only used for testing. We will likely need to use a token of some sort to uniquely identify
    //ToDO: The database is going to need to be updated if we change this to a token. For now, the db is set to auto increment

    private String name;

    private  String iconUrl;

    private ArrayList<Channel> channels;

    private JsonObject primaryOwnerProfile;

    public Template() {
    }

    public Template(String name, int id, String iconUrl, ArrayList<Channel> channels, JsonObject primaryOwnerProfile) {
        this.id = id;
        this.iconUrl = iconUrl;
        this.channels = channels;
        this.primaryOwnerProfile = primaryOwnerProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<Channel> channels) {
        this.channels = channels;
    }

    public JsonObject getPrimaryOwnerProfile() {
        return primaryOwnerProfile;
    }

    public void setPrimaryOwnerProfile(JsonObject primaryOwnerProfile) {
        this.primaryOwnerProfile = primaryOwnerProfile;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", channels=" + channels +
                ", primaryOwnerProfile=" + primaryOwnerProfile +
                '}';
    }
}