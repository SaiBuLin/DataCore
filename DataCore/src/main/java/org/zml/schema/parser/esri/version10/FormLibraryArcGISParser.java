package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.FormLibrary;
public class FormLibraryArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public FormLibraryArcGISParser( FormLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof FormLibrary))
		{
			throw new Exception(" FormLibraryArcGISParser only parse FormLibrary");
		}
		result = true;
		return result;
	}
}