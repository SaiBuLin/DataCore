package org.zml.data.vo.parser;
import org.zml.data.vo.bind.CanBeNull;
public class CanBeNullSQLParser extends SQLParser implements SQLParserAble
{
	public CanBeNullSQLParser( CanBeNull element)
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
		if ( !(this.getQueryDefineElement() instanceof CanBeNull))
		{
			throw new Exception(" CanBeNullSQLParser only parse CanBeNull");
		}
		result = true;
		return result;
	}
}