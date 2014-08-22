package org.zml.form.parser;
import org.zml.form.bind.PageInfo;
public class PageInfoFormParser extends FormParser implements FormParserAble
{
	public PageInfoFormParser( PageInfo element)
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
			throw new Exception(" PageInfoFormParser only parse PageInfo");
		}
		result = true;
		return result;
	}
}