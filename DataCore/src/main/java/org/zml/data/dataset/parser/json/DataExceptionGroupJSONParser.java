package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataExceptionGroup;
public class DataExceptionGroupJSONParser extends JSONParser implements JSONParserAble
{
	public DataExceptionGroupJSONParser( DataExceptionGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof DataExceptionGroup))
		{
			throw new Exception(" DataExceptionGroupJSONParser only parse DataExceptionGroup");
		}
		result = true;
		return result;
	}
}