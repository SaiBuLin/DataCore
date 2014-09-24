package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DatasetNode;
public class DatasetNodeJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public DatasetNodeJSONSetParser( DatasetNode element)
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
		if ( !(this.getQueryDefineElement() instanceof DatasetNode))
		{
			throw new Exception(" DatasetNodeJSONSetParser only parse DatasetNode");
		}
		result = true;
		return result;
	}
}