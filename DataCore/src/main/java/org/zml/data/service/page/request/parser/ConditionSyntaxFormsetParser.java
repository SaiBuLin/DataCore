package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.ConditionSyntax;
public class ConditionSyntaxFormsetParser extends FormsetParser implements FormsetParserAble
{
	public ConditionSyntaxFormsetParser( ConditionSyntax element)
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
		if ( !(this.getQueryDefineElement() instanceof ConditionSyntax))
		{
			throw new Exception(" ConditionSyntaxFormsetParser only parse ConditionSyntax");
		}
		result = true;
		return result;
	}
}