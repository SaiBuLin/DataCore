package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.LibraryGroup;
public class LibraryGroupArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public LibraryGroupArcGISParser( LibraryGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof LibraryGroup))
		{
			throw new Exception(" LibraryGroupArcGISParser only parse LibraryGroup");
		}
		result = true;
		return result;
	}
}