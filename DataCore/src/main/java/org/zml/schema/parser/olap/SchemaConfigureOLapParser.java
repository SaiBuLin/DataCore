package org.zml.schema.parser.olap;
import org.zml.schema.bind.SchemaConfigure;
public class SchemaConfigureOLapParser extends OLapParser implements OLapParserAble
{
	public SchemaConfigureOLapParser( SchemaConfigure element)
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
			throw new Exception(" SchemaConfigureOLapParser only parse SchemaConfigure");
		}
		result = true;
		return result;
	}
}