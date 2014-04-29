package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Schema;
public class SchemaSQLParser extends SQLParser implements SQLParserAble
{
	public SchemaSQLParser( Schema element)
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
		if ( !(this.getQueryDefineElement() instanceof Schema))
		{
			throw new Exception(" SchemaSQLParser only parse Schema");
		}
		result = true;
		return result;
	}
}