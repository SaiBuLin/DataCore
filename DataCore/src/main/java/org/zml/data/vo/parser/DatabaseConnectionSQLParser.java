package org.zml.data.vo.parser;
import org.zml.data.vo.bind.DatabaseConnection;

public class DatabaseConnectionSQLParser extends SQLParser implements SQLParserAble
{
	public DatabaseConnectionSQLParser( DatabaseConnection element)
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
		if ( !(this.getQueryDefineElement() instanceof DatabaseConnection))
		{
			throw new Exception(" DatabaseConnectionSQLParser only parse DatabaseConnection");
		}
		result = true;
		return result;
	}
}