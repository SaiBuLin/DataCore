package org.zml.schema.parser.olap;
import org.zml.schema.bind.Command;
public class CommandOlapParser extends OlapParser implements OlapParserAble
{
	public CommandOlapParser( Command element)
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
			throw new Exception(" CommandOlapParser only parse Command");
		}
		result = true;
		return result;
	}
}