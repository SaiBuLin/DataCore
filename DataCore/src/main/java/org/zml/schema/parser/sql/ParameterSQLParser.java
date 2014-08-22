package org.zml.schema.parser.sql;
import org.zml.schema.bind.Parameter;
public class ParameterSQLParser extends SQLParser implements SQLParserAble
{
	public ParameterSQLParser( Parameter element)
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
		if ( !(this.getQueryDefineElement() instanceof Parameter))
		{
			throw new Exception(" ParameterSQLParser only parse Parameter");
		}
		result = true;
		return result;
	}
}