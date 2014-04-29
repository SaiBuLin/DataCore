package org.zml.data.vo.parser;
import org.zml.data.vo.bind.JSONFieldValue;
public class JSONFieldValueSQLParser extends SQLParser implements SQLParserAble
{
	public JSONFieldValueSQLParser( JSONFieldValue element)
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
		if ( !(this.getQueryDefineElement() instanceof JSONFieldValue))
		{
			throw new Exception(" JSONFieldValueSQLParser only parse JSONFieldValue");
		}
		result = true;
		return result;
	}
}