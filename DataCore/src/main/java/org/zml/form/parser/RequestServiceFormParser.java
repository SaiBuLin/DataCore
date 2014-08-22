package org.zml.form.parser;
import org.zml.form.bind.RequestService;
public class RequestServiceFormParser extends FormParser implements FormParserAble
{
	public RequestServiceFormParser( RequestService element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestService))
		{
			throw new Exception(" RequestServiceFormParser only parse RequestService");
		}
		result = true;
		return result;
	}
}