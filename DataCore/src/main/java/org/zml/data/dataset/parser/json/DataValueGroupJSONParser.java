package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataValueGroup;
public class DataValueGroupJSONParser extends JSONParser implements JSONParserAble
{
	public DataValueGroupJSONParser( DataValueGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof DataValueGroup))
		{
			throw new Exception(" DataValueGroupJSONParser only parse DataValueGroup");
		}
		result = true;
		return result;
	}
}