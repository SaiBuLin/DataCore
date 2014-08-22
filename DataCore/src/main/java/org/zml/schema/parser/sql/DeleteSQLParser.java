package org.zml.schema.parser.sql;
import org.zml.schema.bind.Delete;
public class DeleteSQLParser extends SQLParser implements SQLParserAble
{
	public DeleteSQLParser( Delete element)
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
		if ( !(this.getQueryDefineElement() instanceof Delete))
		{
			throw new Exception(" DeleteSQLParser only parse Delete");
		}
		result = true;
		return result;
	}
}