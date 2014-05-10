package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.SelectSection;
public class SelectSectionFormsetParser extends FormsetParser implements FormsetParserAble
{
	public SelectSectionFormsetParser( SelectSection element)
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
		if ( !(this.getQueryDefineElement() instanceof SelectSection))
		{
			throw new Exception(" SelectSectionFormsetParser only parse SelectSection");
		}
		result = true;
		return result;
	}
}