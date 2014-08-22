package org.zml.form.bind;
public class OrderByColumn extends FieldColumn
{
	private OrderDirection operation;
	public OrderDirection getOperation()
	{
		return this.operation;
	}
	public void setOperation(OrderDirection inoperation )
	{
		this.operation = inoperation;
	}
}