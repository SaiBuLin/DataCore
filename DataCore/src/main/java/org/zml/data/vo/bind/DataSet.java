package org.zml.data.vo.bind;
public class DataSet extends Define
{
	private Attribute attribute;
	private String alias;
	public Attribute getAttribute()
	{
		return this.attribute;
	}
	public void setAttribute(Attribute inattribute )
	{
		this.attribute = inattribute;
	}
	public String getAlias()
	{
		return this.alias;
	}
	public void setAlias(String inalias )
	{
		this.alias = inalias;
	}
}