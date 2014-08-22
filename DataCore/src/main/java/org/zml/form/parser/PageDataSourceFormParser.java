package org.zml.form.parser;
import org.zml.form.bind.PageDataSource;
public class PageDataSourceFormParser extends FormParser implements FormParserAble
{
	public PageDataSourceFormParser( PageDataSource element)
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
		if ( !(this.getQueryDefineElement() instanceof PageDataSource))
		{
			throw new Exception(" PageDataSourceFormParser only parse PageDataSource");
		}
		result = true;
		return result;
	}
}