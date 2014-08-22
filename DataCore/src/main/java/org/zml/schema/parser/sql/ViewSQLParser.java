package org.zml.schema.parser.sql;
import org.zml.schema.bind.View;
public class ViewSQLParser extends SQLParser implements SQLParserAble
{
	public ViewSQLParser( View element)
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
		if ( !(this.getQueryDefineElement() instanceof View))
		{
			throw new Exception(" ViewSQLParser only parse View");
		}
		result = true;
		return result;
	}
}