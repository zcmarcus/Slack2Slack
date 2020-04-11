package com.slack2slack.consume;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateItem {

	@JsonProperty("ownerLastName")
	private String ownerLastName;

	@JsonProperty("channels")
	private List<ChannelsItem> channels;

	@JsonProperty("templateName")
	private String templateName;

	@JsonProperty("ownerDisplayName")
	private String ownerDisplayName;

	@JsonProperty("iconUrl")
	private String iconUrl;

	@JsonProperty("ownerFirstName")
	private String ownerFirstName;

	@JsonProperty("templateId")
	private int templateId;

	@JsonProperty("ownerEmail")
	private String ownerEmail;

	public void setOwnerLastName(String ownerLastName){
		this.ownerLastName = ownerLastName;
	}

	public String getOwnerLastName(){
		return ownerLastName;
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

	public void setOwnerDisplayName(String ownerDisplayName){
		this.ownerDisplayName = ownerDisplayName;
	}

	public String getOwnerDisplayName(){
		return ownerDisplayName;
	}

	public void setIconUrl(String iconUrl){
		this.iconUrl = iconUrl;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	public void setOwnerFirstName(String ownerFirstName){
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerFirstName(){
		return ownerFirstName;
	}

	public void setTemplateId(int templateId){
		this.templateId = templateId;
	}

	public int getTemplateId(){
		return templateId;
	}

	public void setOwnerEmail(String ownerEmail){
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerEmail(){
		return ownerEmail;
	}

	@Override
 	public String toString(){
		return 
			"TemplatesItem{" + 
			"ownerLastName = '" + ownerLastName + '\'' + 
			",channels = '" + channels + '\'' + 
			",templateName = '" + templateName + '\'' + 
			",ownerDisplayName = '" + ownerDisplayName + '\'' + 
			",iconUrl = '" + iconUrl + '\'' + 
			",ownerFirstName = '" + ownerFirstName + '\'' + 
			",templateId = '" + templateId + '\'' + 
			",ownerEmail = '" + ownerEmail + '\'' + 
			"}";
		}
}