package org.zml.form.parser;
import org.zml.form.bind.DataForm;
public class DataFormDemandForm extends DemandForm implements DemandFormAble
{
	public DataFormDemandForm( DataForm element)
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
		if ( !(this.getQueryDefineElement() instanceof DataForm))
		{
			throw new Exception(" DataFormDemandForm only parse DataForm");
		}
		result = true;
		return result;
	}
}