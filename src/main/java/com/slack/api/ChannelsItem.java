package com.slack.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChannelsItem{

	@JsonProperty("is_private")
	private boolean isPrivate;

	@JsonProperty("creator")
	private String creator;

	@JsonProperty("is_member")
	private boolean isMember;

	@JsonProperty("is_mpim")
	private boolean isMpim;

	@JsonProperty("purpose")
	private Purpose purpose;

	@JsonProperty("created")
	private int created;

	@JsonProperty("name_normalized")
	private String nameNormalized;

	@JsonProperty("unlinked")
	private int unlinked;

	@JsonProperty("is_archived")
	private boolean isArchived;

	@JsonProperty("is_channel")
	private boolean isChannel;

	@JsonProperty("is_general")
	private boolean isGeneral;

	@JsonProperty("is_shared")
	private boolean isShared;

	@JsonProperty("members")
	private List<String> members;

	@JsonProperty("num_members")
	private int numMembers;

	@JsonProperty("name")
	private String name;

	@JsonProperty("topic")
	private Topic topic;

	@JsonProperty("id")
	private String id;

	@JsonProperty("previous_names")
	private List<Object> previousNames;

	@JsonProperty("is_org_shared")
	private boolean isOrgShared;

	public void setIsPrivate(boolean isPrivate){
		this.isPrivate = isPrivate;
	}

	public boolean isIsPrivate(){
		return isPrivate;
	}

	public void setCreator(String creator){
		this.creator = creator;
	}

	public String getCreator(){
		return creator;
	}

	public void setIsMember(boolean isMember){
		this.isMember = isMember;
	}

	public boolean isIsMember(){
		return isMember;
	}

	public void setIsMpim(boolean isMpim){
		this.isMpim = isMpim;
	}

	public boolean isIsMpim(){
		return isMpim;
	}

	public void setPurpose(Purpose purpose){
		this.purpose = purpose;
	}

	public Purpose getPurpose(){
		return purpose;
	}

	public void setCreated(int created){
		this.created = created;
	}

	public int getCreated(){
		return created;
	}

	public void setNameNormalized(String nameNormalized){
		this.nameNormalized = nameNormalized;
	}

	public String getNameNormalized(){
		return nameNormalized;
	}

	public void setUnlinked(int unlinked){
		this.unlinked = unlinked;
	}

	public int getUnlinked(){
		return unlinked;
	}

	public void setIsArchived(boolean isArchived){
		this.isArchived = isArchived;
	}

	public boolean isIsArchived(){
		return isArchived;
	}

	public void setIsChannel(boolean isChannel){
		this.isChannel = isChannel;
	}

	public boolean isIsChannel(){
		return isChannel;
	}

	public void setIsGeneral(boolean isGeneral){
		this.isGeneral = isGeneral;
	}

	public boolean isIsGeneral(){
		return isGeneral;
	}

	public void setIsShared(boolean isShared){
		this.isShared = isShared;
	}

	public boolean isIsShared(){
		return isShared;
	}

	public void setMembers(List<String> members){
		this.members = members;
	}

	public List<String> getMembers(){
		return members;
	}

	public void setNumMembers(int numMembers){
		this.numMembers = numMembers;
	}

	public int getNumMembers(){
		return numMembers;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setTopic(Topic topic){
		this.topic = topic;
	}

	public Topic getTopic(){
		return topic;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPreviousNames(List<Object> previousNames){
		this.previousNames = previousNames;
	}

	public List<Object> getPreviousNames(){
		return previousNames;
	}

	public void setIsOrgShared(boolean isOrgShared){
		this.isOrgShared = isOrgShared;
	}

	public boolean isIsOrgShared(){
		return isOrgShared;
	}

	@Override
 	public String toString(){
		return 
			"ChannelsItem{" + 
			"is_private = '" + isPrivate + '\'' + 
			",creator = '" + creator + '\'' + 
			",is_member = '" + isMember + '\'' + 
			",is_mpim = '" + isMpim + '\'' + 
			",purpose = '" + purpose + '\'' + 
			",created = '" + created + '\'' + 
			",name_normalized = '" + nameNormalized + '\'' + 
			",unlinked = '" + unlinked + '\'' + 
			",is_archived = '" + isArchived + '\'' + 
			",is_channel = '" + isChannel + '\'' + 
			",is_general = '" + isGeneral + '\'' + 
			",is_shared = '" + isShared + '\'' + 
			",members = '" + members + '\'' + 
			",num_members = '" + numMembers + '\'' + 
			",name = '" + name + '\'' + 
			",topic = '" + topic + '\'' + 
			",id = '" + id + '\'' + 
			",previous_names = '" + previousNames + '\'' + 
			",is_org_shared = '" + isOrgShared + '\'' + 
			"}";
		}
}