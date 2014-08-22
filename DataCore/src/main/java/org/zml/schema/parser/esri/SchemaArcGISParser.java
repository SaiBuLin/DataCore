package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Schema;
public class SchemaArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public SchemaArcGISParser( Schema element)
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
		if ( !(this.getQueryDefineElement() instanceof Schema))
		{
			throw new Exception(" SchemaArcGISParser only parse Schema");
		}
		result = true;
		return result;
	}
}