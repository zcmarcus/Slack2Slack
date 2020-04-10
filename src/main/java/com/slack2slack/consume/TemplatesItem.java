package com.slack2slack.consume;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplatesItem{

	@JsonProperty("primaryOwnerProfile")
	private PrimaryOwnerProfile primaryOwnerProfile;

	@JsonProperty("channels")
	private List<ChannelsItem> channels;

	@JsonProperty("templateName")
	private String templateName;

	@JsonProperty("iconUrl")
	private String iconUrl;

	public void setPrimaryOwnerProfile(PrimaryOwnerProfile primaryOwnerProfile){
		this.primaryOwnerProfile = primaryOwnerProfile;
	}

	public PrimaryOwnerProfile getPrimaryOwnerProfile(){
		return primaryOwnerProfile;
	}

	public void setChannels(List<ChannelsItem> channels){
		this.channels = channels;
	}

	public List<ChannelsItem> getChannels(){
		return channels;
	}

	public void setTemplateName(String templateName){
		this.templateName = templateName;
	}

	public String getTemplateName(){
		return templateName;
	}

	public void setIconUrl(String iconUrl){
		this.iconUrl = iconUrl;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	@Override
 	public String toString(){
		return 
			"TemplatesItem{" + 
			"primaryOwnerProfile = '" + primaryOwnerProfile + '\'' + 
			",channels = '" + channels + '\'' + 
			",templateName = '" + templateName + '\'' + 
			",iconUrl = '" + iconUrl + '\'' + 
			"}";
		}
}