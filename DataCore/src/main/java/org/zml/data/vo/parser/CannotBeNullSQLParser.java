package org.zml.data.vo.parser;
import org.zml.data.vo.bind.CannotBeNull;
public class CannotBeNullSQLParser extends SQLParser implements SQLParserAble
{
	public CannotBeNullSQLParser( CannotBeNull element)
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
		if ( !(this.getQueryDefineElement() instanceof CannotBeNull))
		{
			throw new Exception(" CannotBeNullSQLParser only parse CannotBeNull");
		}
		result = true;
		return result;
	}
}