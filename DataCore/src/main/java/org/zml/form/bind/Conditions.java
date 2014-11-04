package org.zml.form.bind;
import java.util.ArrayList;
public class Conditions extends Condition
{
	private OperationLogical operation;
	private ArrayList<Condition> condition = new ArrayList<Condition>();
	private Boolean bracket;
	public OperationLogical getOperation()
	{
		return this.operation;
	}
	public void setOperation(OperationLogical inoperation )
	{
		this.operation = inoperation;
	}
	public ArrayList<Condition> getCondition()
	{
		return this.condition;
	}
	public void setCondition(ArrayList<Condition> incondition )
	{
		this.condition = incondition;
	}
	public Boolean getBracket()
	{
		return this.bracket;
	}
	public void setBracket(Boolean inbracket )
	{
		this.bracket = inbracket;
	}
}