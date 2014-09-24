package org.zml.form.parser;
import org.zml.form.bind.Conditions;
public class ConditionsDemandForm extends DemandForm implements DemandFormAble
{
	public ConditionsDemandForm( Conditions element)
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
		if ( !(this.getQueryDefineElement() instanceof Conditions))
		{
			throw new Exception(" ConditionsDemandForm only parse Conditions");
		}
		result = true;
		return result;
	}
}