package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.OrderByColumn;
public class OrderByColumnVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public OrderByColumnVOServiceRequest( OrderByColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof OrderByColumn))
		{
			throw new Exception(" OrderByColumnVOServiceRequest only parse OrderByColumn");
		}
		result = true;
		return result;
	}
}