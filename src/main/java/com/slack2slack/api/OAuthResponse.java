package com.slack2slack.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class OAuthResponse{

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("authed_user")
	private AuthedUser authedUser;

	@JsonProperty("bot_user_id")
	private String botUserId;

	@JsonProperty("enterprise")
	private Object enterprise;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("team")
	private Team team;

	@JsonProperty("ok")
	private boolean ok;

	@JsonProperty("token_type")
	private String tokenType;

	@JsonProperty("app_id")
	private String appId;

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public void setAuthedUser(AuthedUser authedUser){
		this.authedUser = authedUser;
	}

	public AuthedUser getAuthedUser(){
		return authedUser;
	}

	public void setBotUserId(String botUserId){
		this.botUserId = botUserId;
	}

	public String getBotUserId(){
		return botUserId;
	}

	public void setEnterprise(Object enterprise){
		this.enterprise = enterprise;
	}

	public Object getEnterprise(){
		return enterprise;
	}

	public void setScope(String scope){
		this.scope = scope;
	}

	public String getScope(){
		return scope;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
	}

	public void setOk(boolean ok){
		this.ok = ok;
	}

	public boolean isOk(){
		return ok;
	}

	public void setTokenType(String tokenType){
		this.tokenType = tokenType;
	}

	public String getTokenType(){
		return tokenType;
	}

	public void setAppId(String appId){
		this.appId = appId;
	}

	public String getAppId(){
		return appId;
	}

	@Override
 	public String toString(){
		return 
			"OAuthResponse{" + 
			"access_token = '" + accessToken + '\'' + 
			",authed_user = '" + authedUser + '\'' + 
			",bot_user_id = '" + botUserId + '\'' + 
			",enterprise = '" + enterprise + '\'' + 
			",scope = '" + scope + '\'' + 
			",team = '" + team + '\'' + 
			",ok = '" + ok + '\'' + 
			",token_type = '" + tokenType + '\'' + 
			",app_id = '" + appId + '\'' + 
			"}";
		}
}