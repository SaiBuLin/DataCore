package org.zml.form.parser;
import org.zml.form.bind.ConditionSyntax;
public class ConditionSyntaxFormParser extends FormParser implements FormParserAble
{
	public ConditionSyntaxFormParser( ConditionSyntax element)
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
			throw new Exception(" ConditionSyntaxFormParser only parse ConditionSyntax");
		}
		result = true;
		return result;
	}
}