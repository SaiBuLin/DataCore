package org.zml.schema.parser.sql;
import org.zml.schema.bind.Relation;
public class RelationSQLParser extends SQLParser implements SQLParserAble
{
	public RelationSQLParser( Relation element)
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
		if ( !(this.getQueryDefineElement() instanceof Relation))
		{
			throw new Exception(" RelationSQLParser only parse Relation");
		}
		result = true;
		return result;
	}
}