package com.slack2slack.consume;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimaryOwnerProfile{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("displayName")
	private String displayName;

	@JsonProperty("email")
	private String email;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"PrimaryOwnerProfile{" + 
			"firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",displayName = '" + displayName + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}