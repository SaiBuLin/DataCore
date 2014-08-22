package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.Table;
public class TableJSONParser extends JSONParser implements JSONParserAble
{
	public TableJSONParser( Table element)
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
		if ( !(this.getQueryDefineElement() instanceof Table))
		{
			throw new Exception(" TableJSONParser only parse Table");
		}
		result = true;
		return result;
	}
}