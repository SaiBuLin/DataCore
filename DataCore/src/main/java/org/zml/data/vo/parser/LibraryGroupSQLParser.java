package org.zml.data.vo.parser;
import org.zml.data.vo.bind.LibraryGroup;
public class LibraryGroupSQLParser extends SQLParser implements SQLParserAble
{
	public LibraryGroupSQLParser( LibraryGroup element)
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
			throw new Exception(" LibraryGroupSQLParser only parse LibraryGroup");
		}
		result = true;
		return result;
	}
}