package org.zml.schema.parser.ersi;
import org.zml.schema.bind.ReferenceLibrary;
public class ReferenceLibraryArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public ReferenceLibraryArcGISParser( ReferenceLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof ReferenceLibrary))
		{
			throw new Exception(" ReferenceLibraryArcGISParser only parse ReferenceLibrary");
		}
		result = true;
		return result;
	}
}