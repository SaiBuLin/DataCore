package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataFieldGroup;
public class DataFieldGroupJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public DataFieldGroupJSONSetParser( DataFieldGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof DataFieldGroup))
		{
			throw new Exception(" DataFieldGroupJSONSetParser only parse DataFieldGroup");
		}
		result = true;
		return result;
	}
}