package org.zml.data.vo.parser;
import org.zml.data.vo.bind.StatusGroup;
public class StatusGroupSQLParser extends SQLParser implements SQLParserAble
{
	public StatusGroupSQLParser( StatusGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof StatusGroup))
		{
			throw new Exception(" StatusGroupSQLParser only parse StatusGroup");
		}
		result = true;
		return result;
	}
}