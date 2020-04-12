package com.slack.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PublicChannelsResponse{

	@JsonProperty("channels")
	private List<PublicChannelItem> channels;

	@JsonProperty("response_metadata")
	private ResponseMetadata responseMetadata;

	@JsonProperty("ok")
	private boolean ok;

	public void setChannels(List<PublicChannelItem> channels){
		this.channels = channels;
	}

	public List<PublicChannelItem> getChannels(){
		return channels;
	}

	public void setResponseMetadata(ResponseMetadata responseMetadata){
		this.responseMetadata = responseMetadata;
	}

	public ResponseMetadata getResponseMetadata(){
		return responseMetadata;
	}

	public void setOk(boolean ok){
		this.ok = ok;
	}

	public boolean isOk(){
		return ok;
	}

	@Override
 	public String toString(){
		return 
			"PublicChannelsResponse{" + 
			"channels = '" + channels + '\'' + 
			",response_metadata = '" + responseMetadata + '\'' + 
			",ok = '" + ok + '\'' + 
			"}";
		}
}