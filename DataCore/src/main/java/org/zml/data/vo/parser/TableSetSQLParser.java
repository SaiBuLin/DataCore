package org.zml.data.vo.parser;
import org.zml.data.vo.bind.TableSet;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class TableSetSQLParser extends SQLParser implements SQLParserAble
{
	public TableSetSQLParser( TableSet element)
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
		if ( !(this.getQueryDefineElement() instanceof TableSet))
		{
			throw new Exception(" TableSetSQLParser only parse TableSet");
		}
		result = true;
		return result;
	}
	

	
}