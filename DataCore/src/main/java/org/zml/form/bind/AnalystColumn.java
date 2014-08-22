package org.zml.form.bind;
public class AnalystColumn extends FieldColumn
{
	private SQLFunction function;
	public SQLFunction getFunction()
	{
		return this.function;
	}
	public void setFunction(SQLFunction infunction )
	{
		this.function = infunction;
	}
}