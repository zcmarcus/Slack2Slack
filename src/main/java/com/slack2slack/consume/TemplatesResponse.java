package com.slack2slack.consume;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplatesResponse {

	@JsonProperty("templates")
	private List<TemplatesItem> templates;

	public void setTemplates(List<TemplatesItem> templates){
		this.templates = templates;
	}

	public List<TemplatesItem> getTemplates(){
		return templates;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"templates = '" + templates + '\'' + 
			"}";
		}
}