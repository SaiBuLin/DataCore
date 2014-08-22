package org.zml.schema.parser.sql;
import org.zml.schema.bind.SchemaDefine;
public class SchemaDefineSQLParser extends SQLParser implements SQLParserAble
{
	public SchemaDefineSQLParser( SchemaDefine element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaDefine))
		{
			throw new Exception(" SchemaDefineSQLParser only parse SchemaDefine");
		}
		result = true;
		return result;
	}
}