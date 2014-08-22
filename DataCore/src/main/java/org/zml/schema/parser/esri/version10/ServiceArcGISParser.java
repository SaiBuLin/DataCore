package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.Service;
public class ServiceArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public ServiceArcGISParser( Service element)
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
		if ( !(this.getQueryDefineElement() instanceof Service))
		{
			throw new Exception(" ServiceArcGISParser only parse Service");
		}
		result = true;
		return result;
	}
}