package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.DataSource;
public class DataSourceFormsetParser extends FormsetParser implements FormsetParserAble
{
	public DataSourceFormsetParser( DataSource element)
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
		if ( !(this.getQueryDefineElement() instanceof DataSource))
		{
			throw new Exception(" DataSourceFormsetParser only parse DataSource");
		}
		result = true;
		return result;
	}
}