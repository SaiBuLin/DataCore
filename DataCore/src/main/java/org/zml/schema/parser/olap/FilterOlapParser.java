package org.zml.schema.parser.olap;
import org.zml.schema.bind.Filter;
public class FilterOlapParser extends OlapParser implements OlapParserAble
{
	public FilterOlapParser( Filter element)
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
		if ( !(this.getQueryDefineElement() instanceof Filter))
		{
			throw new Exception(" FilterOlapParser only parse Filter");
		}
		result = true;
		return result;
	}
}