package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.RequestPartGroup;
public class RequestPartGroupVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public RequestPartGroupVOServiceRequest( RequestPartGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestPartGroup))
		{
			throw new Exception(" RequestPartGroupVOServiceRequest only parse RequestPartGroup");
		}
		result = true;
		return result;
	}
}