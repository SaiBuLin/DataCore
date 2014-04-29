package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.SimpleField;
public class SimpleFieldVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public SimpleFieldVOServiceRequest( SimpleField element)
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
		if ( !(this.getQueryDefineElement() instanceof SimpleField))
		{
			throw new Exception(" SimpleFieldVOServiceRequest only parse SimpleField");
		}
		result = true;
		return result;
	}
}