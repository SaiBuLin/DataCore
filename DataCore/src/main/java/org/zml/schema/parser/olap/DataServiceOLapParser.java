package org.zml.schema.parser.olap;
import org.zml.schema.bind.DataService;
public class DataServiceOLapParser extends OLapParser implements OLapParserAble
{
	public DataServiceOLapParser( DataService element)
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
		if ( !(this.getQueryDefineElement() instanceof DataService))
		{
			throw new Exception(" DataServiceOLapParser only parse DataService");
		}
		result = true;
		return result;
	}
}