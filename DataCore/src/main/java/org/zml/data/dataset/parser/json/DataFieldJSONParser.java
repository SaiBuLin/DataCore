package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataField;
public class DataFieldJSONParser extends JSONParser implements JSONParserAble
{
	public DataFieldJSONParser( DataField element)
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
		if ( !(this.getQueryDefineElement() instanceof DataField))
		{
			throw new Exception(" DataFieldJSONParser only parse DataField");
		}
		result = true;
		return result;
	}
}