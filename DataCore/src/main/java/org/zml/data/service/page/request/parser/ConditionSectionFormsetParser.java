package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.ConditionSection;
public class ConditionSectionFormsetParser extends FormsetParser implements FormsetParserAble
{
	public ConditionSectionFormsetParser( ConditionSection element)
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
		if ( !(this.getQueryDefineElement() instanceof ConditionSection))
		{
			throw new Exception(" ConditionSectionFormsetParser only parse ConditionSection");
		}
		result = true;
		return result;
	}
}