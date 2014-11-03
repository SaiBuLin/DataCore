package org.zml.schema.parser.olap;
import org.zml.schema.bind.SqlLibrary;
public class SqlLibraryOlapParser extends OlapParser implements OlapParserAble
{
	public SqlLibraryOlapParser( SqlLibrary element)
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
			throw new Exception(" SqlLibraryOlapParser only parse SqlLibrary");
		}
		result = true;
		return result;
	}
}