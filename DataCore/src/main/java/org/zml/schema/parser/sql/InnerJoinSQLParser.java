package org.zml.schema.parser.sql;
import org.zml.schema.bind.InnerJoin;
public class InnerJoinSQLParser extends SQLParser implements SQLParserAble
{
	public InnerJoinSQLParser( InnerJoin element)
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
		if ( !(this.getQueryDefineElement() instanceof InnerJoin))
		{
			throw new Exception(" InnerJoinSQLParser only parse InnerJoin");
		}
		result = true;
		return result;
	}
}