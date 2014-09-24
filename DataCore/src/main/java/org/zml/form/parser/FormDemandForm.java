package org.zml.form.parser;
import org.zml.form.bind.Form;
public class FormDemandForm extends DemandForm implements DemandFormAble
{
	public FormDemandForm( Form element)
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
		if ( !(this.getQueryDefineElement() instanceof Form))
		{
			throw new Exception(" FormDemandForm only parse Form");
		}
		result = true;
		return result;
	}
}