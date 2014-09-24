package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataValue;
public class DataValueJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public DataValueJSONSetParser( DataValue element)
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
		if ( !(this.getQueryDefineElement() instanceof DataValue))
		{
			throw new Exception(" DataValueJSONSetParser only parse DataValue");
		}
		result = true;
		return result;
	}
}