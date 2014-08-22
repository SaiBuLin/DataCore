package org.zml.schema.parser.olap;
import org.zml.schema.bind.Command;
public class CommandOLapParser extends OLapParser implements OLapParserAble
{
	public CommandOLapParser( Command element)
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
			throw new Exception(" CommandOLapParser only parse Command");
		}
		result = true;
		return result;
	}
}