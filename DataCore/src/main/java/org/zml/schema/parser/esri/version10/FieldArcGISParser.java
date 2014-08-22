package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.Field;
public class FieldArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public FieldArcGISParser( Field element)
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
		if ( !(this.getQueryDefineElement() instanceof Field))
		{
			throw new Exception(" FieldArcGISParser only parse Field");
		}
		result = true;
		return result;
	}
}