package org.zml.schema.parser.sql;
import org.zml.schema.bind.Command;
public class CommandSQLParser extends SQLParser implements SQLParserAble
{
	public CommandSQLParser( Command element)
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
		if ( !(this.getQueryDefineElement() instanceof Command))
		{
			throw new Exception(" CommandSQLParser only parse Command");
		}
		result = true;
		return result;
	}
}