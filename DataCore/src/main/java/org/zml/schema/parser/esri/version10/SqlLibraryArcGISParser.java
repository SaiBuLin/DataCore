package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.SqlLibrary;
public class SqlLibraryArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public SqlLibraryArcGISParser( SqlLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof SqlLibrary))
		{
			throw new Exception(" SqlLibraryArcGISParser only parse SqlLibrary");
		}
		result = true;
		return result;
	}
}