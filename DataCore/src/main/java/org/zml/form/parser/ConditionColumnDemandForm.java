package org.zml.form.parser;
import org.zml.form.bind.ConditionColumn;
public class ConditionColumnDemandForm extends DemandForm implements DemandFormAble
{
	public ConditionColumnDemandForm( ConditionColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof ConditionColumn))
		{
			throw new Exception(" ConditionColumnDemandForm only parse ConditionColumn");
		}
		result = true;
		return result;
	}
}