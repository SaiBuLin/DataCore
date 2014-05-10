package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.QueryFormNode;
public class QueryFormNodeFormsetParser extends FormsetParser implements FormsetParserAble
{
	public QueryFormNodeFormsetParser( QueryFormNode element)
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
			throw new Exception(" QueryFormNodeFormsetParser only parse QueryFormNode");
		}
		result = true;
		return result;
	}
}