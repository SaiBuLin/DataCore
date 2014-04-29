package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.RequestField;
public class RequestFieldVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public RequestFieldVOServiceRequest( RequestField element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestField))
		{
			throw new Exception(" RequestFieldVOServiceRequest only parse RequestField");
		}
		result = true;
		return result;
	}
}