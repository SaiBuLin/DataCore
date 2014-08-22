package org.zml.schema.bind;
public class AttributeLibrary extends Library
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