package org.zml.data.vo.bind;
public class DoActionSet extends DataSet
{
	private String methodname;
	private String actionclass;
	public String getMethodname()
	{
		return this.methodname;
	}
	public void setMethodname(String inmethodname )
	{
		this.methodname = inmethodname;
	}
	public String getActionclass()
	{
		return this.actionclass;
	}
	public void setActionclass(String inactionclass )
	{
		this.actionclass = inactionclass;
	}
}