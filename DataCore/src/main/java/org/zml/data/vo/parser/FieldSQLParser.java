package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Field;
public class FieldSQLParser extends SQLParser implements SQLParserAble
{
	public FieldSQLParser( Field element)
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
		if ( !(this.getQueryDefineElement() instanceof Field))
		{
			throw new Exception(" FieldSQLParser only parse Field");
		}
		result = true;
		return result;
	}
}