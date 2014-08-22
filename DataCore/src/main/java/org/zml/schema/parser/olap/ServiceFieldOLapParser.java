package org.zml.schema.parser.olap;
import org.zml.schema.bind.ServiceField;
public class ServiceFieldOLapParser extends OLapParser implements OLapParserAble
{
	public ServiceFieldOLapParser( ServiceField element)
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
			throw new Exception(" ServiceFieldOLapParser only parse ServiceField");
		}
		result = true;
		return result;
	}
}