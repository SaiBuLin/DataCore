package org.zml.schema.parser.sql;
import org.zml.schema.bind.NoneExists;
public class NoneExistsSQLParser extends SQLParser implements SQLParserAble
{
	public NoneExistsSQLParser( NoneExists element)
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
		if ( !(this.getQueryDefineElement() instanceof NoneExists))
		{
			throw new Exception(" NoneExistsSQLParser only parse NoneExists");
		}
		result = true;
		return result;
	}
}