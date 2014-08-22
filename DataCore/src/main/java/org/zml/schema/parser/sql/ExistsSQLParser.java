package org.zml.schema.parser.sql;
import org.zml.schema.bind.Exists;
public class ExistsSQLParser extends SQLParser implements SQLParserAble
{
	public ExistsSQLParser( Exists element)
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
		if ( !(this.getQueryDefineElement() instanceof Exists))
		{
			throw new Exception(" ExistsSQLParser only parse Exists");
		}
		result = true;
		return result;
	}
}