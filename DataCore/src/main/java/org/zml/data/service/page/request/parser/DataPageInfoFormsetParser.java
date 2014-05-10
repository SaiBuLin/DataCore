package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.DataPageInfo;
public class DataPageInfoFormsetParser extends FormsetParser implements FormsetParserAble
{
	public DataPageInfoFormsetParser( DataPageInfo element)
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
		if ( !(this.getQueryDefineElement() instanceof DataPageInfo))
		{
			throw new Exception(" DataPageInfoFormsetParser only parse DataPageInfo");
		}
		result = true;
		return result;
	}
}