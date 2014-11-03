package org.zml.schema.parser.olap;
import org.zml.schema.bind.Service;
public class ServiceOlapParser extends OlapParser implements OlapParserAble
{
	public ServiceOlapParser( Service element)
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
			throw new Exception(" ServiceOlapParser only parse Service");
		}
		result = true;
		return result;
	}
}