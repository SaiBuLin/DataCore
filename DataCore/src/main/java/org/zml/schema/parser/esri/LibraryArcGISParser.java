package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Library;
public class LibraryArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public LibraryArcGISParser( Library element)
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
		if ( !(this.getQueryDefineElement() instanceof Library))
		{
			throw new Exception(" LibraryArcGISParser only parse Library");
		}
		result = true;
		return result;
	}
}