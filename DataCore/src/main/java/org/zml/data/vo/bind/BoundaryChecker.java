package org.zml.data.vo.bind;
public class BoundaryChecker extends Validator
{
	private String defaultValue;
	private FieldLogical boundary;
	public String getDefaultValue()
	{
		return this.defaultValue;
	}
	public void setDefaultValue(String indefaultValue )
	{
		this.defaultValue = indefaultValue;
	}
	public FieldLogical getBoundary()
	{
		return this.boundary;
	}
	public void setBoundary(FieldLogical inboundary )
	{
		this.boundary = inboundary;
	}
}