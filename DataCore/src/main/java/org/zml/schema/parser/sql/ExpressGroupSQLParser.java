package org.zml.schema.parser.sql;
import org.zml.schema.bind.ExpressGroup;
public class ExpressGroupSQLParser extends SQLParser implements SQLParserAble
{
	public ExpressGroupSQLParser( ExpressGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof ExpressGroup))
		{
			throw new Exception(" ExpressGroupSQLParser only parse ExpressGroup");
		}
		result = true;
		return result;
	}
}