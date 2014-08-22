package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.TableGroup;
public class TableGroupJSONParser extends JSONParser implements JSONParserAble
{
	public TableGroupJSONParser( TableGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof TableGroup))
		{
			throw new Exception(" TableGroupJSONParser only parse TableGroup");
		}
		result = true;
		return result;
	}
}