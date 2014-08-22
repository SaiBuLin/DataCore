package org.zml.schema.parser.sql;
import org.zml.schema.bind.Service;
public class ServiceSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceSQLParser( Service element)
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
		if ( !(this.getQueryDefineElement() instanceof Service))
		{
			throw new Exception(" ServiceSQLParser only parse Service");
		}
		result = true;
		return result;
	}
}