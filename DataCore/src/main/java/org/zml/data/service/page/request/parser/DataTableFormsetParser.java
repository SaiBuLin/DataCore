package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.DataTable;
public class DataTableFormsetParser extends FormsetParser implements FormsetParserAble
{
	public DataTableFormsetParser( DataTable element)
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
			throw new Exception(" DataTableFormsetParser only parse DataTable");
		}
		result = true;
		return result;
	}
}