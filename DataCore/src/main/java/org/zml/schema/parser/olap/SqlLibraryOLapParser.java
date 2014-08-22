package org.zml.schema.parser.olap;
import org.zml.schema.bind.SqlLibrary;
public class SqlLibraryOLapParser extends OLapParser implements OLapParserAble
{
	public SqlLibraryOLapParser( SqlLibrary element)
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
			throw new Exception(" SqlLibraryOLapParser only parse SqlLibrary");
		}
		result = true;
		return result;
	}
}