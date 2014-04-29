package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.OrderByField;
public class OrderByFieldVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public OrderByFieldVOServiceRequest( OrderByField element)
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
		if ( !(this.getQueryDefineElement() instanceof OrderByField))
		{
			throw new Exception(" OrderByFieldVOServiceRequest only parse OrderByField");
		}
		result = true;
		return result;
	}
}