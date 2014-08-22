package org.zml.schema.parser.sql;
import org.zml.schema.bind.ServiceField;
public class ServiceFieldSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceFieldSQLParser( ServiceField element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceField))
		{
			throw new Exception(" ServiceFieldSQLParser only parse ServiceField");
		}
		result = true;
		return result;
	}
}