package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.DataService;
public class DataServiceArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public DataServiceArcGISParser( DataService element)
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
			throw new Exception(" DataServiceArcGISParser only parse DataService");
		}
		result = true;
		return result;
	}
}