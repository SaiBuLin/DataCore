package org.zml.schema.parser.sql;
import org.zml.schema.bind.SchemaGroup;
public class SchemaGroupSQLParser extends SQLParser implements SQLParserAble
{
	public SchemaGroupSQLParser( SchemaGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaGroup))
		{
			throw new Exception(" SchemaGroupSQLParser only parse SchemaGroup");
		}
		result = true;
		return result;
	}
}