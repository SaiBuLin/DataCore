package org.zml.data.vo.command.parser;
import org.zml.data.vo.command.bind.RequestParameterGroup;
public class RequestParameterGroupSQLCommand extends SQLCommand implements SQLCommandAble
{
	public RequestParameterGroupSQLCommand( RequestParameterGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestParameterGroup))
		{
			throw new Exception(" RequestParameterGroupSQLCommand only parse RequestParameterGroup");
		}
		result = true;
		return result;
	}
}