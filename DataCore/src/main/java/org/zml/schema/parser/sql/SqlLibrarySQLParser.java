package org.zml.schema.parser.sql;
import org.zml.schema.bind.SqlLibrary;
public class SqlLibrarySQLParser extends SQLParser implements SQLParserAble
{
	public SqlLibrarySQLParser( SqlLibrary element)
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
			throw new Exception(" SqlLibrarySQLParser only parse SqlLibrary");
		}
		result = true;
		return result;
	}
}