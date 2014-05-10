package org.zml.data.service.page.request.bind;

import org.zml.data.vo.bind.FieldLogical;

public class ConditionColumn extends FieldColumn
{
	private String defaultvalue;
	private FieldLogical operation;
	public String getDefaultvalue()
	{
		return this.defaultvalue;
	}
	public void setDefaultvalue(String indefaultvalue )
	{
		this.defaultvalue = indefaultvalue;
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