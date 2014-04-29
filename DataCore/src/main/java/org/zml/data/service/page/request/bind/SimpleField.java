package org.zml.data.service.page.request.bind;
public class SimpleField extends RequestField
{
	private String value;
	private String field;
	public String getValue()
	{
		return this.value;
	}
	public void setValue(String invalue )
	{
		this.value = invalue;
	}
	public String getField()
	{
		return this.field;
	}
	public void setField(String infield )
	{
		this.field = infield;
	}
}