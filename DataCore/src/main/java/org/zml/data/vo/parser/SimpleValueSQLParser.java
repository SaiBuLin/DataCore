package org.zml.data.vo.parser;
import org.zml.data.vo.bind.SimpleValue;
public class SimpleValueSQLParser extends SQLParser implements SQLParserAble
{
	public SimpleValueSQLParser( SimpleValue element)
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
		if ( !(this.getQueryDefineElement() instanceof SimpleValue))
		{
			throw new Exception(" SimpleValueSQLParser only parse SimpleValue");
		}
		result = true;
		return result;
	}
}