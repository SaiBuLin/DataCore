package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.Section;
public class SectionFormsetParser extends FormsetParser implements FormsetParserAble
{
	public SectionFormsetParser( Section element)
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
		if ( !(this.getQueryDefineElement() instanceof Section))
		{
			throw new Exception(" SectionFormsetParser only parse Section");
		}
		result = true;
		return result;
	}
}