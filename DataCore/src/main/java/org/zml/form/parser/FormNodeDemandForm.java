package org.zml.form.parser;
import org.zml.form.bind.FormNode;
public class FormNodeDemandForm extends DemandForm implements DemandFormAble
{
	public FormNodeDemandForm( FormNode element)
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
		if ( !(this.getQueryDefineElement() instanceof FormNode))
		{
			throw new Exception(" FormNodeDemandForm only parse FormNode");
		}
		result = true;
		return result;
	}
}