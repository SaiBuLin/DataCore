package org.zml.schema.bind;
public class FieldValueExpress extends Express
{
	private FieldLogical operationship;
	private String value;
	private String field;
	private String form;
	public FieldLogical getOperationship()
	{
		return this.operationship;
	}
	public void setOperationship(FieldLogical inoperationship )
	{
		this.operationship = inoperationship;
	}
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
	public String getForm()
	{
		return this.form;
	}
	public void setForm(String inform )
	{
		this.form = inform;
	}
}