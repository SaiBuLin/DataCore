package org.zml.form.parser;
import org.zml.form.bind.VOFormService;
public class VOFormServiceDemandForm extends DemandForm implements DemandFormAble
{
	public VOFormServiceDemandForm( VOFormService element)
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
		if ( !(this.getQueryDefineElement() instanceof VOFormService))
		{
			throw new Exception(" VOFormServiceDemandForm only parse VOFormService");
		}
		result = true;
		return result;
	}
}