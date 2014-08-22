package org.zml.schema.parser.sql;
import org.zml.schema.bind.SchemaConfigure;
public class SchemaConfigureSQLParser extends SQLParser implements SQLParserAble
{
	public SchemaConfigureSQLParser( SchemaConfigure element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaConfigure))
		{
			throw new Exception(" SchemaConfigureSQLParser only parse SchemaConfigure");
		}
		result = true;
		return result;
	}
}