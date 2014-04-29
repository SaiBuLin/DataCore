package org.zml.data.vo.command.parser;
import org.zml.data.vo.command.bind.CommandDefine;
public class CommandDefineSQLCommand extends SQLCommand implements SQLCommandAble
{
	public CommandDefineSQLCommand( CommandDefine element)
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
		if ( !(this.getQueryDefineElement() instanceof CommandDefine))
		{
			throw new Exception(" CommandDefineSQLCommand only parse CommandDefine");
		}
		result = true;
		return result;
	}
}