package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.RequestColumn;
public class RequestColumnVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public RequestColumnVOServiceRequest( RequestColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestColumn))
		{
			throw new Exception(" RequestColumnVOServiceRequest only parse RequestColumn");
		}
		result = true;
		return result;
	}
}