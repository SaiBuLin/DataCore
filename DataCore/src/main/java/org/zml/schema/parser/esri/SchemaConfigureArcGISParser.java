package org.zml.schema.parser.ersi;
import org.zml.schema.bind.SchemaConfigure;
public class SchemaConfigureArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public SchemaConfigureArcGISParser( SchemaConfigure element)
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
			throw new Exception(" SchemaConfigureArcGISParser only parse SchemaConfigure");
		}
		result = true;
		return result;
	}
}