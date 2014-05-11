package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FormsRelation;
public class FormsRelationSQLParser extends SQLParser implements SQLParserAble
{
	public FormsRelationSQLParser( FormsRelation element)
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
		if ( !(this.getQueryDefineElement() instanceof FormsRelation))
		{
			throw new Exception(" FormsRelationSQLParser only parse FormsRelation");
		}
		result = true;
		return result;
	}
}