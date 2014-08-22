package org.zml.schema.bind;
public class SchemaDefine extends Define
{
	private Attribute attribute;
	private String description;
	private String label;
	public Attribute getAttribute()
	{
		return this.attribute;
	}
	public void setAttribute(Attribute inattribute )
	{
		this.attribute = inattribute;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String indescription )
	{
		this.description = indescription;
	}
	public String getLabel()
	{
		return this.label;
	}
	public void setLabel(String inlabel )
	{
		this.label = inlabel;
	}
}