package org.zml.data.service.page.request.bind;

import org.zml.data.vo.bind.SQLFunction;


public class AnalystColumn extends FieldColumn
{
	private SQLFunction function;
	public SQLFunction getFunction()
	{
		return this.function;
	}
	public void setFunction( SQLFunction infunction )
	{
		this.function = infunction;
	}
}