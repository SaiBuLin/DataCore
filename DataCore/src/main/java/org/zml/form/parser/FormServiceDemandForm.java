package org.zml.form.parser;
import org.zml.form.bind.FormService;
public class FormServiceDemandForm extends DemandForm implements DemandFormAble
{
	public FormServiceDemandForm( FormService element)
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
		if ( !(this.getQueryDefineElement() instanceof FormService))
		{
			throw new Exception(" FormServiceDemandForm only parse FormService");
		}
		result = true;
		return result;
	}
}