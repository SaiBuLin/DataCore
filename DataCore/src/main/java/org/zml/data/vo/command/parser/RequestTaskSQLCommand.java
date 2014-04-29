package org.zml.data.vo.command.parser;
import org.zml.data.vo.command.bind.RequestTask;
public class RequestTaskSQLCommand extends SQLCommand implements SQLCommandAble
{
	public RequestTaskSQLCommand( RequestTask element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestTask))
		{
			throw new Exception(" RequestTaskSQLCommand only parse RequestTask");
		}
		result = true;
		return result;
	}
}