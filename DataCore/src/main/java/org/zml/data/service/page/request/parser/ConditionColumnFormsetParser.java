package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.ConditionColumn;
public class ConditionColumnFormsetParser extends FormsetParser implements FormsetParserAble
{
	public ConditionColumnFormsetParser( ConditionColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof ConditionColumn))
		{
			throw new Exception(" ConditionColumnFormsetParser only parse ConditionColumn");
		}
		result = true;
		return result;
	}
}