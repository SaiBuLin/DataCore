package org.zml.schema.bind;
public class Query extends Command
{
	private Factory factory;
	public Factory getFactory()
	{
		return this.factory;
	}
	public void setFactory(Factory infactory )
	{
		this.factory = infactory;
	}
}