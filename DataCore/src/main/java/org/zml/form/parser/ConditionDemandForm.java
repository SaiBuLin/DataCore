package org.zml.form.parser;
import org.zml.form.bind.Condition;
public class ConditionDemandForm extends DemandForm implements DemandFormAble
{
	public ConditionDemandForm( Condition element)
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
		if ( !(this.getQueryDefineElement() instanceof Condition))
		{
			throw new Exception(" ConditionDemandForm only parse Condition");
		}
		result = true;
		return result;
	}
}