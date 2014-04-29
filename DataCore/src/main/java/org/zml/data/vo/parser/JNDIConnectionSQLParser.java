package org.zml.data.vo.parser;
import org.zml.data.vo.bind.JNDIConnection;
public class JNDIConnectionSQLParser extends SQLParser implements SQLParserAble
{
	public JNDIConnectionSQLParser( JNDIConnection element)
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
		if ( !(this.getQueryDefineElement() instanceof JNDIConnection))
		{
			throw new Exception(" JNDIConnectionSQLParser only parse JNDIConnection");
		}
		result = true;
		return result;
	}
}