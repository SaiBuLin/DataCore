package org.zml.form.parser;
import org.zml.form.bind.QueryFormNode;
public class QueryFormNodeFormParser extends FormParser implements FormParserAble
{
	public QueryFormNodeFormParser( QueryFormNode element)
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
			throw new Exception(" QueryFormNodeFormParser only parse QueryFormNode");
		}
		result = true;
		return result;
	}
}