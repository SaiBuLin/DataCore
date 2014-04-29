package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Connection;
public class ConnectionSQLParser extends SQLParser implements SQLParserAble
{
	public ConnectionSQLParser( Connection element)
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
		if ( !(this.getQueryDefineElement() instanceof Connection))
		{
			throw new Exception(" ConnectionSQLParser only parse Connection");
		}
		result = true;
		return result;
	}
}