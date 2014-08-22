package org.zml.schema.parser.sql;
import org.zml.schema.bind.RelationGroup;
public class RelationGroupSQLParser extends SQLParser implements SQLParserAble
{
	public RelationGroupSQLParser( RelationGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof RelationGroup))
		{
			throw new Exception(" RelationGroupSQLParser only parse RelationGroup");
		}
		result = true;
		return result;
	}
}