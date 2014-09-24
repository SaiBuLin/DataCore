package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataField;
public class DataFieldJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public DataFieldJSONSetParser( DataField element)
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
			throw new Exception(" DataFieldJSONSetParser only parse DataField");
		}
		result = true;
		return result;
	}
}