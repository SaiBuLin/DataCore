package org.zml.schema.parser.sql;
import org.zml.schema.bind.Update;
public class UpdateSQLParser extends SQLParser implements SQLParserAble
{
	public UpdateSQLParser( Update element)
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
		if ( !(this.getQueryDefineElement() instanceof Update))
		{
			throw new Exception(" UpdateSQLParser only parse Update");
		}
		result = true;
		return result;
	}
}