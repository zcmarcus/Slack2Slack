package com.slack2slack.consume;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplatesCollection{

	@JsonProperty("templates")
	private List<TemplateItem> templates;

	public void setTemplates(List<TemplateItem> templates){
		this.templates = templates;
	}

	public List<TemplateItem> getTemplates(){
		return templates;
	}

	@Override
 	public String toString(){
		return 
			"TemplatesCollection{" + 
			"templates = '" + templates + '\'' + 
			"}";
		}
}