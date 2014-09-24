package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.ColumnField;
public class ColumnFieldJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public ColumnFieldJSONSetParser( ColumnField element)
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
			throw new Exception(" ColumnFieldJSONSetParser only parse ColumnField");
		}
		result = true;
		return result;
	}
}