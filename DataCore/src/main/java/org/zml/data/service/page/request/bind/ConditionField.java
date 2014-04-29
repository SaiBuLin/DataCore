package org.zml.data.service.page.request.bind;

import org.zml.data.vo.bind.FieldLogical;

public class ConditionField extends SimpleField
{
	private FieldLogical operation;
	
	public FieldLogical getOperation()
	{
		return this.operation;
	}
	
	public void setOperation( FieldLogical inoperation )
	{
		this.operation = inoperation;
	}
}