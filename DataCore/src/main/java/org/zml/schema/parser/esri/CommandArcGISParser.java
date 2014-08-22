package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Command;
public class CommandArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public CommandArcGISParser( Command element)
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
			throw new Exception(" CommandArcGISParser only parse Command");
		}
		result = true;
		return result;
	}
}