package org.zml.schema.parser.olap;
import org.zml.schema.bind.LibraryGroup;
public class LibraryGroupOlapParser extends OlapParser implements OlapParserAble
{
	public LibraryGroupOlapParser( LibraryGroup element)
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
			throw new Exception(" LibraryGroupOlapParser only parse LibraryGroup");
		}
		result = true;
		return result;
	}
}