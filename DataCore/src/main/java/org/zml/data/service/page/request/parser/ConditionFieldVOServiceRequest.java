package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.ConditionField;
public class ConditionFieldVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public ConditionFieldVOServiceRequest( ConditionField element)
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
		if ( !(this.getQueryDefineElement() instanceof ConditionField))
		{
			throw new Exception(" ConditionFieldVOServiceRequest only parse ConditionField");
		}
		result = true;
		return result;
	}
}