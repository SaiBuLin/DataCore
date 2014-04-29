package org.zml.data.service.page.request.bind;
public class ConditionColumn extends RequestPart
{
	private ConditionSyntax conditionSyntax;
	public ConditionSyntax getConditionSyntax()
	{
		return this.conditionSyntax;
	}
	public void setConditionSyntax(ConditionSyntax inconditionSyntax )
	{
		this.conditionSyntax = inconditionSyntax;
	}
}