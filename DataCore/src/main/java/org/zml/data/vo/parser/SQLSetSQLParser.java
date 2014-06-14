package org.zml.data.vo.parser;

import org.zml.data.vo.bind.SQLSet;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class SQLSetSQLParser extends SQLParser implements SQLParserAble
{
	public SQLSetSQLParser( SQLSet element)
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
		if ( !(this.getQueryDefineElement() instanceof SQLSet))
		{
			throw new Exception(" SQLSetSQLParser only parse SQLSet");
		}
		result = true;
		return result;
	}
	

}