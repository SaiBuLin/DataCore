package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.MyValue;
public class MyValueJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public MyValueJSONSetParser( MyValue element)
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
			throw new Exception(" MyValueJSONSetParser only parse MyValue");
		}
		result = true;
		return result;
	}
}