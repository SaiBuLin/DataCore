package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.ExtendException;
public class ExtendExceptionJSONParser extends JSONParser implements JSONParserAble
{
	public ExtendExceptionJSONParser( ExtendException element)
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
		if ( !(this.getQueryDefineElement() instanceof ExtendException))
		{
			throw new Exception(" ExtendExceptionJSONParser only parse ExtendException");
		}
		result = true;
		return result;
	}
}