package org.zml.schema.parser.olap;
import org.zml.schema.bind.SchemaConfigure;
public class SchemaConfigureOlapParser extends OlapParser implements OlapParserAble
{
	public SchemaConfigureOlapParser( SchemaConfigure element)
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
			throw new Exception(" SchemaConfigureOlapParser only parse SchemaConfigure");
		}
		result = true;
		return result;
	}
}