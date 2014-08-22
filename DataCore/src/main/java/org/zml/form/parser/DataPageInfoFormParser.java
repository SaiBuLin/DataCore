package org.zml.form.parser;
import org.zml.form.bind.DataPageInfo;
public class DataPageInfoFormParser extends FormParser implements FormParserAble
{
	public DataPageInfoFormParser( DataPageInfo element)
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
			throw new Exception(" DataPageInfoFormParser only parse DataPageInfo");
		}
		result = true;
		return result;
	}
}