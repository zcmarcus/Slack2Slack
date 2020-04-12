package com.slack.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMetadata{

	@JsonProperty("next_cursor")
	private String nextCursor;

	public void setNextCursor(String nextCursor){
		this.nextCursor = nextCursor;
	}

	public String getNextCursor(){
		return nextCursor;
	}

	@Override
 	public String toString(){
		return 
			"ResponseMetadata{" + 
			"next_cursor = '" + nextCursor + '\'' + 
			"}";
		}
}