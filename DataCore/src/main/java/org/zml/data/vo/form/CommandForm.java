package org.zml.data.vo.form;

import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.command.bind.CommandConfiguration;

public class CommandForm {
	Map<String,Object> properties = new HashMap<String,Object>();
	
	CommandConfiguration command = new CommandConfiguration();	
	
	//String command = "";
	
	String alias = "";

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
	/*
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	*/

	public CommandConfiguration getCommand() {
		return command;
	}

	public void setCommand(CommandConfiguration command) {
		this.command = command;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	
}
