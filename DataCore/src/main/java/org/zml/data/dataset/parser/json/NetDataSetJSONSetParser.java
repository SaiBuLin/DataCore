package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.NetDataSet;
public class NetDataSetJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public NetDataSetJSONSetParser( NetDataSet element)
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
		if ( !(this.getQueryDefineElement() instanceof NetDataSet))
		{
			throw new Exception(" NetDataSetJSONSetParser only parse NetDataSet");
		}
		result = true;
		return result;
	}
}