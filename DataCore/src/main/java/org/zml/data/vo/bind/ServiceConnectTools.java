package org.zml.data.vo.bind;
public class ServiceConnectTools extends ConnectTools
{
	private String classname;
	private Attribute attribute;
	public String getClassname()
	{
		return this.classname;
	}
	public void setClassname(String inclassname )
	{
		this.classname = inclassname;
	}
	public Attribute getAttribute()
	{
		return this.attribute;
	}
	public void setAttribute(Attribute inattribute )
	{
		this.attribute = inattribute;
	}
}