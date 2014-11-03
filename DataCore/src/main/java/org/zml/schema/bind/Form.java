package org.zml.schema.bind;
public class Form extends Schema
{
	private String content;
	private Service service;
	private Field field;
	private String alias;
	private Command command;
	private Boolean onlytable;
	public String getContent()
	{
		return this.content;
	}
	public void setContent(String incontent )
	{
		this.content = incontent;
	}
	public Service getService()
	{
		return this.service;
	}
	public void setService(Service inservice )
	{
		this.service = inservice;
	}
	public Field getField()
	{
		return this.field;
	}
	public void setField(Field infield )
	{
		this.field = infield;
	}
	public String getAlias()
	{
		return this.alias;
	}
	public void setAlias(String inalias )
	{
		this.alias = inalias;
	}
	public Command getCommand()
	{
		return this.command;
	}
	public void setCommand(Command incommand )
	{
		this.command = incommand;
	}
	public Boolean getOnlytable()
	{
		return this.onlytable;
	}
	public void setOnlytable(Boolean inonlytable )
	{
		this.onlytable = inonlytable;
	}
}