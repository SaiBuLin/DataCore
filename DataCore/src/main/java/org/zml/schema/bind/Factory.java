package org.zml.schema.bind;
public class Factory extends Define
{
	private Attribute attribute;
	public Attribute getAttribute()
	{
		return this.attribute;
	}
	public void setAttribute(Attribute inattribute )
	{
		this.attribute = inattribute;
	}
}