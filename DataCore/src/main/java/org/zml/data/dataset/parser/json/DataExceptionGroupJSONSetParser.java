package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataExceptionGroup;
public class DataExceptionGroupJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public DataExceptionGroupJSONSetParser( DataExceptionGroup element)
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
			throw new Exception(" DataExceptionGroupJSONSetParser only parse DataExceptionGroup");
		}
		result = true;
		return result;
	}
}