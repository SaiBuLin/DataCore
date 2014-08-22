package org.zml.form.parser;
import org.zml.form.bind.DataTable;
public class DataTableFormParser extends FormParser implements FormParserAble
{
	public DataTableFormParser( DataTable element)
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
			throw new Exception(" DataTableFormParser only parse DataTable");
		}
		result = true;
		return result;
	}
}