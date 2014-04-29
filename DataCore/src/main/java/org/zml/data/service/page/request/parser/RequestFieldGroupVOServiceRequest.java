package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.RequestFieldGroup;
public class RequestFieldGroupVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public RequestFieldGroupVOServiceRequest( RequestFieldGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestFieldGroup))
		{
			throw new Exception(" RequestFieldGroupVOServiceRequest only parse RequestFieldGroup");
		}
		result = true;
		return result;
	}
}