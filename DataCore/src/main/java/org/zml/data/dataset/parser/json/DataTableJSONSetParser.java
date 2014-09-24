package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.DataTable;
public class DataTableJSONSetParser extends JSONSetParser implements JSONSetParserAble
{
	public DataTableJSONSetParser( DataTable element)
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
		if ( !(this.getQueryDefineElement() instanceof DataTable))
		{
			throw new Exception(" DataTableJSONSetParser only parse DataTable");
		}
		result = true;
		return result;
	}
}