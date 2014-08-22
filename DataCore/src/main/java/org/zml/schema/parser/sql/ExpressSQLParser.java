package org.zml.schema.parser.sql;
import org.zml.schema.bind.Express;
public class ExpressSQLParser extends SQLParser implements SQLParserAble
{
	public ExpressSQLParser( Express element)
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
		if ( !(this.getQueryDefineElement() instanceof Express))
		{
			throw new Exception(" ExpressSQLParser only parse Express");
		}
		result = true;
		return result;
	}
}