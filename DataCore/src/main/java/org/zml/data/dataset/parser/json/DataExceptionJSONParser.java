package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataException;
public class DataExceptionJSONParser extends JSONParser implements JSONParserAble
{
	public DataExceptionJSONParser( DataException element)
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
		if ( !(this.getQueryDefineElement() instanceof DataException))
		{
			throw new Exception(" DataExceptionJSONParser only parse DataException");
		}
		result = true;
		return result;
	}
}