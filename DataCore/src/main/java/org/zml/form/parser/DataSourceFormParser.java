package org.zml.form.parser;
import org.zml.form.bind.DataSource;
public class DataSourceFormParser extends FormParser implements FormParserAble
{
	public DataSourceFormParser( DataSource element)
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
			throw new Exception(" DataSourceFormParser only parse DataSource");
		}
		result = true;
		return result;
	}
}