package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DatasetNode;
public class DatasetNodeJSONParser extends JSONParser implements JSONParserAble
{
	public DatasetNodeJSONParser( DatasetNode element)
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
			throw new Exception(" DatasetNodeJSONParser only parse DatasetNode");
		}
		result = true;
		return result;
	}
}