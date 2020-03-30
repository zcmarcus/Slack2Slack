package com.slack2slack.entity;

public class Channel {

    private String name;
    private String topic;
    private String purpose;

    public Channel() {
    }

    public Channel(String name, String topic, String purpose) {
        this.name = name;
        this.topic = topic;
        this.purpose = purpose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
