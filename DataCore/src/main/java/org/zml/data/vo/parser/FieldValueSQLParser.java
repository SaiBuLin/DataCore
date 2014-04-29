package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FieldValue;
public class FieldValueSQLParser extends SQLParser implements SQLParserAble
{
	public FieldValueSQLParser( FieldValue element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldValue))
		{
			throw new Exception(" FieldValueSQLParser only parse FieldValue");
		}
		result = true;
		return result;
	}
}