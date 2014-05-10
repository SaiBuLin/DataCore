package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.SectionGroup;
public class SectionGroupFormsetParser extends FormsetParser implements FormsetParserAble
{
	public SectionGroupFormsetParser( SectionGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof SectionGroup))
		{
			throw new Exception(" SectionGroupFormsetParser only parse SectionGroup");
		}
		result = true;
		return result;
	}
}