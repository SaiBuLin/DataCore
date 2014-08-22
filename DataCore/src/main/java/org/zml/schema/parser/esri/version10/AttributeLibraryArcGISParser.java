package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.AttributeLibrary;
public class AttributeLibraryArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public AttributeLibraryArcGISParser( AttributeLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof AttributeLibrary))
		{
			throw new Exception(" AttributeLibraryArcGISParser only parse AttributeLibrary");
		}
		result = true;
		return result;
	}
}