package org.zml.form.parser;
import org.zml.form.bind.ConditionSection;
public class ConditionSectionDemandForm extends DemandForm implements DemandFormAble
{
	public ConditionSectionDemandForm( ConditionSection element)
	{
		setQueryDefineElement(element);
	}
	public boolean checkQueryElementComfort() throws Exception
	{
		boolean result = false;
		if ( this.getQueryDefineElement()  == null )
		{
			throw new Exception(" queryDefineElement cannot be null. ");
		}
		if ( !(this.getQueryDefineElement() instanceof ConditionSection))
		{
			throw new Exception(" ConditionSectionDemandForm only parse ConditionSection");
		}
		result = true;
		return result;
	}
}