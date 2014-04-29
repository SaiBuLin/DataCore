package org.zml.data.vo.parser;
import org.zml.data.vo.bind.DoActionSet;
public class DoActionSetSQLParser extends SQLParser implements SQLParserAble
{
	public DoActionSetSQLParser( DoActionSet element)
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
		if ( !(this.getQueryDefineElement() instanceof DoActionSet))
		{
			throw new Exception(" DoActionSetSQLParser only parse DoActionSet");
		}
		result = true;
		return result;
	}
}