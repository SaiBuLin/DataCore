package org.zml.schema.parser.olap;
import org.zml.schema.bind.ServiceField;
public class ServiceFieldOlapParser extends OlapParser implements OlapParserAble
{
	public ServiceFieldOlapParser( ServiceField element)
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
			throw new Exception(" ServiceFieldOlapParser only parse ServiceField");
		}
		result = true;
		return result;
	}
}