package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.QueryRequest;
public class QueryRequestVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public QueryRequestVOServiceRequest( QueryRequest element)
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
		if ( !(this.getQueryDefineElement() instanceof QueryRequest))
		{
			throw new Exception(" QueryRequestVOServiceRequest only parse QueryRequest");
		}
		result = true;
		return result;
	}
}