package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.ConditionColumn;
public class ConditionColumnVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public ConditionColumnVOServiceRequest( ConditionColumn element)
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
			throw new Exception(" ConditionColumnVOServiceRequest only parse ConditionColumn");
		}
		result = true;
		return result;
	}
}