package org.zml.data.service.page.request.bind;

import java.util.ArrayList;

import org.zml.data.vo.bind.OperationLogical;

public class ComplexConditionSyntax extends ConditionSyntax
{
	private OperationLogical operation;
	private ArrayList<ConditionSyntax> conditionSyntax = new ArrayList<ConditionSyntax>();
	public OperationLogical getOperation()
	{
		return this.operation;
	}
	public void setOperation(OperationLogical inoperation )
	{
		this.operation = inoperation;
	}
	public ArrayList<ConditionSyntax> getConditionSyntax()
	{
		return this.conditionSyntax;
	}
	public void setConditionSyntax(ArrayList<ConditionSyntax> inconditionSyntax )
	{
		this.conditionSyntax = inconditionSyntax;
	}
}