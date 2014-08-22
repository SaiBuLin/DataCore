package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataFieldGroup;
public class DataFieldGroupJSONParser extends JSONParser implements JSONParserAble
{
	public DataFieldGroupJSONParser( DataFieldGroup element)
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
			throw new Exception(" DataFieldGroupJSONParser only parse DataFieldGroup");
		}
		result = true;
		return result;
	}
}