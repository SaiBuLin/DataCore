package org.zml.schema.parser.olap;
import org.zml.schema.bind.Library;
public class LibraryOLapParser extends OLapParser implements OLapParserAble
{
	public LibraryOLapParser( Library element)
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
			throw new Exception(" LibraryOLapParser only parse Library");
		}
		result = true;
		return result;
	}
}