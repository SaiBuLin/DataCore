package org.zml.schema.parser.olap;
import org.zml.schema.bind.Query;
public class QueryOlapParser extends OlapParser implements OlapParserAble
{
	public QueryOlapParser( Query element)
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
		if ( !(this.getQueryDefineElement() instanceof Query))
		{
			throw new Exception(" QueryOlapParser only parse Query");
		}
		result = true;
		return result;
	}
}