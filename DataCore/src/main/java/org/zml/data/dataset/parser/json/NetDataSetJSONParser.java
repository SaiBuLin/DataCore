package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.NetDataSet;
public class NetDataSetJSONParser extends JSONParser implements JSONParserAble
{
	public NetDataSetJSONParser( NetDataSet element)
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
			throw new Exception(" NetDataSetJSONParser only parse NetDataSet");
		}
		result = true;
		return result;
	}
}