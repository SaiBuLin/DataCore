package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.ServiceField;
public class ServiceFieldArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public ServiceFieldArcGISParser( ServiceField element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceField))
		{
			throw new Exception(" ServiceFieldArcGISParser only parse ServiceField");
		}
		result = true;
		return result;
	}
}