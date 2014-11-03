package org.zml.schema.parser.olap;
import org.zml.schema.bind.Library;
public class LibraryOlapParser extends OlapParser implements OlapParserAble
{
	public LibraryOlapParser( Library element)
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
			throw new Exception(" LibraryOlapParser only parse Library");
		}
		result = true;
		return result;
	}
}