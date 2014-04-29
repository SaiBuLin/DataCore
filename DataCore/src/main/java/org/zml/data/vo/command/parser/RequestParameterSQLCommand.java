package org.zml.data.vo.command.parser;
import org.zml.data.vo.command.bind.RequestParameter;
public class RequestParameterSQLCommand extends SQLCommand implements SQLCommandAble
{
	public RequestParameterSQLCommand( RequestParameter element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestParameter))
		{
			throw new Exception(" RequestParameterSQLCommand only parse RequestParameter");
		}
		result = true;
		return result;
	}
}