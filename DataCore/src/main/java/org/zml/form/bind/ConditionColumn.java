package org.zml.form.bind;
public class ConditionColumn extends FieldColumn
{
	private String content;
	private FieldLogical operation;
	public String getContent()
	{
		return this.content;
	}
	public void setContent(String incontent )
	{
		this.content = incontent;
	}
	public FieldLogical getOperation()
	{
		return this.operation;
	}
	public void setOperation(FieldLogical inoperation )
	{
		this.operation = inoperation;
	}
}