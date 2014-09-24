package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.TableGroup;
public class TableGroupJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public TableGroupJSONSetParser( TableGroup element)
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
			throw new Exception(" TableGroupJSONSetParser only parse TableGroup");
		}
		result = true;
		return result;
	}
}