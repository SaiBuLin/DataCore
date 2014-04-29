package org.zml.data.vo.bind;
public class ExtendMethodChecker extends Validator
{
	private Attribute attribute;
	private String className;
	public Attribute getAttribute()
	{
		return this.attribute;
	}
	public void setAttribute(Attribute inattribute )
	{
		this.attribute = inattribute;
	}
	public String getClassName()
	{
		return this.className;
	}
	public void setClassName(String inclassName )
	{
		this.className = inclassName;
	}
}