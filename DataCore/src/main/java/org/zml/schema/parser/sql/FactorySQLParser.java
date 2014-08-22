package org.zml.schema.parser.sql;
import org.zml.schema.bind.Factory;
public class FactorySQLParser extends SQLParser implements SQLParserAble
{
	public FactorySQLParser( Factory element)
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
		if ( !(this.getQueryDefineElement() instanceof Factory))
		{
			throw new Exception(" FactorySQLParser only parse Factory");
		}
		result = true;
		return result;
	}
}