package org.zml.form.parser;
import org.zml.form.bind.ConditionSection;
public class ConditionSectionFormParser extends FormParser implements FormParserAble
{
	public ConditionSectionFormParser( ConditionSection element)
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
			throw new Exception(" ConditionSectionFormParser only parse ConditionSection");
		}
		result = true;
		return result;
	}
}