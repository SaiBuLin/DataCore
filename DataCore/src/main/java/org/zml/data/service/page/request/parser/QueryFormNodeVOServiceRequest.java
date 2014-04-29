package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.QueryFormNode;
public class QueryFormNodeVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public QueryFormNodeVOServiceRequest( QueryFormNode element)
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
		if ( !(this.getQueryDefineElement() instanceof QueryFormNode))
		{
			throw new Exception(" QueryFormNodeVOServiceRequest only parse QueryFormNode");
		}
		result = true;
		return result;
	}
}