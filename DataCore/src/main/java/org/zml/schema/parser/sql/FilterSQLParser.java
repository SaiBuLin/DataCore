package org.zml.schema.parser.sql;
import org.zml.schema.bind.Filter;
public class FilterSQLParser extends SQLParser implements SQLParserAble
{
	public FilterSQLParser( Filter element)
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
			throw new Exception(" FilterSQLParser only parse Filter");
		}
		result = true;
		return result;
	}
}