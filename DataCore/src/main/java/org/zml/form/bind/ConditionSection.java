package org.zml.form.bind;
public class ConditionSection extends Section
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