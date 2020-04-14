package com.slack2slack.consume;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChannelsItem{

	@JsonProperty("channelId")
	private int channelId;

	@JsonProperty("purpose")
	private String purpose;

	@JsonProperty("name")
	private String name;

	@JsonProperty("topic")
	private String topic;

	public void setPurpose(String purpose){
		this.purpose = purpose;
	}

	public String getPurpose(){
		return purpose;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setTopic(String topic){
		this.topic = topic;
	}

	public String getTopic(){
		return topic;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	@Override
	public String toString() {
		return "ChannelsItem{" +
				"channelId=" + channelId +
				", purpose='" + purpose + '\'' +
				", name='" + name + '\'' +
				", topic='" + topic + '\'' +
				'}';
	}
}