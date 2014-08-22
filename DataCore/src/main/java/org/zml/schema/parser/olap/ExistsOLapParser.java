package org.zml.schema.parser.olap;
import org.zml.schema.bind.Exists;
public class ExistsOLapParser extends OLapParser implements OLapParserAble
{
	public ExistsOLapParser( Exists element)
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
		if ( !(this.getQueryDefineElement() instanceof Exists))
		{
			throw new Exception(" ExistsOLapParser only parse Exists");
		}
		result = true;
		return result;
	}
}