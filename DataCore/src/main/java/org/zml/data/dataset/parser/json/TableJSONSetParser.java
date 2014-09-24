package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.Table;
public class TableJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public TableJSONSetParser( Table element)
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
			throw new Exception(" TableJSONSetParser only parse Table");
		}
		result = true;
		return result;
	}
}