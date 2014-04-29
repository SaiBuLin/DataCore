package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Library;
public class LibrarySQLParser extends SQLParser implements SQLParserAble
{
	public LibrarySQLParser( Library element)
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
			throw new Exception(" LibrarySQLParser only parse Library");
		}
		result = true;
		return result;
	}
}