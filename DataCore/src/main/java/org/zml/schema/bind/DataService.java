package org.zml.schema.bind;
public class DataService extends Service
{
	private Attribute attribute;
	private Factory factory;
	public Attribute getAttribute()
	{
		return this.attribute;
	}
	public void setAttribute(Attribute inattribute )
	{
		this.attribute = inattribute;
	}
	public Factory getFactory()
	{
		return this.factory;
	}
	public void setFactory(Factory infactory )
	{
		this.factory = infactory;
	}
}