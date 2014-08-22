package org.zml.schema.parser.sql;
import org.zml.schema.bind.RightOuterJoin;
public class RightOuterJoinSQLParser extends SQLParser implements SQLParserAble
{
	public RightOuterJoinSQLParser( RightOuterJoin element)
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
		if ( !(this.getQueryDefineElement() instanceof RightOuterJoin))
		{
			throw new Exception(" RightOuterJoinSQLParser only parse RightOuterJoin");
		}
		result = true;
		return result;
	}
}