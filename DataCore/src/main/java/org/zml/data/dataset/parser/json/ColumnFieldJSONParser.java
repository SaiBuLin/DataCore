package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.ColumnField;
public class ColumnFieldJSONParser extends JSONParser implements JSONParserAble
{
	public ColumnFieldJSONParser( ColumnField element)
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
		if ( !(this.getQueryDefineElement() instanceof ColumnField))
		{
			throw new Exception(" ColumnFieldJSONParser only parse ColumnField");
		}
		result = true;
		return result;
	}
}