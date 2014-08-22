package org.zml.schema.parser.sql;
import org.zml.schema.bind.ViewRelation;
public class ViewRelationSQLParser extends SQLParser implements SQLParserAble
{
	public ViewRelationSQLParser( ViewRelation element)
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
		if ( !(this.getQueryDefineElement() instanceof ViewRelation))
		{
			throw new Exception(" ViewRelationSQLParser only parse ViewRelation");
		}
		result = true;
		return result;
	}
}