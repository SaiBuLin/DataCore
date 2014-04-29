package org.zml.data.vo.parser;
import org.zml.data.vo.bind.SchemaValue;
public class SchemaValueSQLParser extends SQLParser implements SQLParserAble
{
	public SchemaValueSQLParser( SchemaValue element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaValue))
		{
			throw new Exception(" SchemaValueSQLParser only parse SchemaValue");
		}
		result = true;
		return result;
	}
}