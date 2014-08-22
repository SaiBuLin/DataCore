package org.zml.schema.parser.sql;
import org.zml.schema.bind.LeftOuterJoin;
public class LeftOuterJoinSQLParser extends SQLParser implements SQLParserAble
{
	public LeftOuterJoinSQLParser( LeftOuterJoin element)
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
		if ( !(this.getQueryDefineElement() instanceof LeftOuterJoin))
		{
			throw new Exception(" LeftOuterJoinSQLParser only parse LeftOuterJoin");
		}
		result = true;
		return result;
	}
}