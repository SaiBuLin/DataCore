package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.SchemaDefine;
public class SchemaDefineArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public SchemaDefineArcGISParser( SchemaDefine element)
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
			throw new Exception(" SchemaDefineArcGISParser only parse SchemaDefine");
		}
		result = true;
		return result;
	}
}