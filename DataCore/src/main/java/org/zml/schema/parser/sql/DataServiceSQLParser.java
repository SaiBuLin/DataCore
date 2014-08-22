package org.zml.schema.parser.sql;
import org.zml.schema.bind.DataService;
public class DataServiceSQLParser extends SQLParser implements SQLParserAble
{
	public DataServiceSQLParser( DataService element)
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
		if ( !(this.getQueryDefineElement() instanceof DataService))
		{
			throw new Exception(" DataServiceSQLParser only parse DataService");
		}
		result = true;
		return result;
	}
}