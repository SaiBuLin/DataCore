package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.MyValue;
public class MyValueJSONParser extends JSONParser implements JSONParserAble
{
	public MyValueJSONParser( MyValue element)
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
		if ( !(this.getQueryDefineElement() instanceof MyValue))
		{
			throw new Exception(" MyValueJSONParser only parse MyValue");
		}
		result = true;
		return result;
	}
}