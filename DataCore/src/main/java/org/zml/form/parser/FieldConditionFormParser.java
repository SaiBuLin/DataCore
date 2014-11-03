package org.zml.form.parser;
import org.zml.form.bind.FieldCondition;
public class FieldConditionFormParser extends FormParser implements FormParserAble
{
	public FieldConditionFormParser( FieldCondition element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldCondition))
		{
			throw new Exception(" FieldConditionFormParser only parse FieldCondition");
		}
		result = true;
		return result;
	}
}