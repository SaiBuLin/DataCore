package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.GroupBySection;
public class GroupBySectionFormsetParser extends FormsetParser implements FormsetParserAble
{
	public GroupBySectionFormsetParser( GroupBySection element)
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
		if ( !(this.getQueryDefineElement() instanceof GroupBySection))
		{
			throw new Exception(" GroupBySectionFormsetParser only parse GroupBySection");
		}
		result = true;
		return result;
	}
}