package org.zml.form.parser;
import org.zml.form.bind.SQLFormService;
public class SQLFormServiceDemandForm extends DemandForm implements DemandFormAble
{
	public SQLFormServiceDemandForm( SQLFormService element)
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
		if ( !(this.getQueryDefineElement() instanceof SQLFormService))
		{
			throw new Exception(" SQLFormServiceDemandForm only parse SQLFormService");
		}
		result = true;
		return result;
	}
}