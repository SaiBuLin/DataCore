package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.Attribute;
public class AttributeArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public AttributeArcGISParser( Attribute element)
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
		if ( !(this.getQueryDefineElement() instanceof Attribute))
		{
			throw new Exception(" AttributeArcGISParser only parse Attribute");
		}
		result = true;
		return result;
	}
}