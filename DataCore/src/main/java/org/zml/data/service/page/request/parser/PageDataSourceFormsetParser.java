package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.PageDataSource;
public class PageDataSourceFormsetParser extends FormsetParser implements FormsetParserAble
{
	public PageDataSourceFormsetParser( PageDataSource element)
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
			throw new Exception(" PageDataSourceFormsetParser only parse PageDataSource");
		}
		result = true;
		return result;
	}
}