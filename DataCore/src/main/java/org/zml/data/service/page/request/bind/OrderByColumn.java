package org.zml.data.service.page.request.bind;

import org.zml.data.vo.bind.OrderDirection;


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