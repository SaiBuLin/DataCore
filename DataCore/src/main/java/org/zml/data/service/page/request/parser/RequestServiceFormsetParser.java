package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.RequestService;
public class RequestServiceFormsetParser extends FormsetParser implements FormsetParserAble
{
	public RequestServiceFormsetParser( RequestService element)
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
			throw new Exception(" RequestServiceFormsetParser only parse RequestService");
		}
		result = true;
		return result;
	}
}