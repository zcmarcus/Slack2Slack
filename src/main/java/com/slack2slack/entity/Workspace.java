package com.slack2slack.entity;

import javax.json.JsonObject;
import java.util.ArrayList;

public class Workspace {

    private int id; // Identifier is only used for testing.

    private String name;

    private  String iconUrl;

    private ArrayList<Channel> channels;

    private JsonObject primaryOwnerProfile;

    public Workspace() {
    }

    public Workspace(String name, int id, String iconUrl, ArrayList<Channel> channels, JsonObject primaryOwnerProfile) {
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
        return "Workspace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", channels=" + channels +
                ", primaryOwnerProfile=" + primaryOwnerProfile +
                '}';
    }
}
