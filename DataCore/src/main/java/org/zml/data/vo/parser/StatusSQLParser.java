package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Status;
public class StatusSQLParser extends SQLParser implements SQLParserAble
{
	public StatusSQLParser( Status element)
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
		if ( !(this.getQueryDefineElement() instanceof Status))
		{
			throw new Exception(" StatusSQLParser only parse Status");
		}
		result = true;
		return result;
	}
}