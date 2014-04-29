package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.RequestPart;
public class RequestPartVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public RequestPartVOServiceRequest( RequestPart element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestPart))
		{
			throw new Exception(" RequestPartVOServiceRequest only parse RequestPart");
		}
		result = true;
		return result;
	}
}