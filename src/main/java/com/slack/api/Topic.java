package com.slack.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Topic{

	@JsonProperty("last_set")
	private int lastSet;

	@JsonProperty("creator")
	private String creator;

	@JsonProperty("value")
	private String value;

	public void setLastSet(int lastSet){
		this.lastSet = lastSet;
	}

	public int getLastSet(){
		return lastSet;
	}

	public void setCreator(String creator){
		this.creator = creator;
	}

	public String getCreator(){
		return creator;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Topic{" + 
			"last_set = '" + lastSet + '\'' + 
			",creator = '" + creator + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}