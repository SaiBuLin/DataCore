package org.zml.form.parser;
import org.zml.form.bind.FormGroup;
public class FormGroupDemandForm extends DemandForm implements DemandFormAble
{
	public FormGroupDemandForm( FormGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FormGroup))
		{
			throw new Exception(" FormGroupDemandForm only parse FormGroup");
		}
		result = true;
		return result;
	}
}