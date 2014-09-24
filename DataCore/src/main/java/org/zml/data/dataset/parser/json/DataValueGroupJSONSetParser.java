package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataValueGroup;
public class DataValueGroupJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public DataValueGroupJSONSetParser( DataValueGroup element)
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
			throw new Exception(" DataValueGroupJSONSetParser only parse DataValueGroup");
		}
		result = true;
		return result;
	}
}