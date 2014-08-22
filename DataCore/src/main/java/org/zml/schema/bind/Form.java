package org.zml.schema.bind;
public class Form extends Schema
{
	private Service service;
	private Field field;
	private Command command;
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
	public Command getCommand()
	{
		return this.command;
	}
	public void setCommand(Command incommand )
	{
		this.command = incommand;
	}
}