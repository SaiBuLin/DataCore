package org.zml.schema.parser.olap;
import org.zml.schema.bind.Update;
public class UpdateOLapParser extends OLapParser implements OLapParserAble
{
	public UpdateOLapParser( Update element)
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
		if ( !(this.getQueryDefineElement() instanceof Update))
		{
			throw new Exception(" UpdateOLapParser only parse Update");
		}
		result = true;
		return result;
	}
}