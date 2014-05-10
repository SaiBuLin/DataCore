package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.PageInfo;
public class PageInfoFormsetParser extends FormsetParser implements FormsetParserAble
{
	public PageInfoFormsetParser( PageInfo element)
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
		if ( !(this.getQueryDefineElement() instanceof PageInfo))
		{
			throw new Exception(" PageInfoFormsetParser only parse PageInfo");
		}
		result = true;
		return result;
	}
}