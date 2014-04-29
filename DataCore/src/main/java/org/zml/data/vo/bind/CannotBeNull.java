package org.zml.data.vo.bind;
public class CannotBeNull extends Validator
{
	private String defaultValue;
	public String getDefaultValue()
	{
		return this.defaultValue;
	}
	public void setDefaultValue(String indefaultValue )
	{
		this.defaultValue = indefaultValue;
	}
}