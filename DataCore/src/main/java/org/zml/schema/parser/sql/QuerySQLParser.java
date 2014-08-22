package org.zml.schema.parser.sql;
import org.zml.schema.bind.Query;
public class QuerySQLParser extends SQLParser implements SQLParserAble
{
	public QuerySQLParser( Query element)
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
			throw new Exception(" QuerySQLParser only parse Query");
		}
		result = true;
		return result;
	}
}