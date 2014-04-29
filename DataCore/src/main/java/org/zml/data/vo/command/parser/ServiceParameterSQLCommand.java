package org.zml.data.vo.command.parser;
import org.zml.data.vo.command.bind.ServiceParameter;
public class ServiceParameterSQLCommand extends SQLCommand implements SQLCommandAble
{
	public ServiceParameterSQLCommand( ServiceParameter element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceParameter))
		{
			throw new Exception(" ServiceParameterSQLCommand only parse ServiceParameter");
		}
		result = true;
		return result;
	}
}