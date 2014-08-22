package org.zml.form.bind;
import java.util.ArrayList;
public class ComplexWhere extends ConditionSyntax
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