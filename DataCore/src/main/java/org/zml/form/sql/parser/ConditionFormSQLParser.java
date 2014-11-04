package org.zml.form.sql.parser;
import org.zml.form.bind.Condition;
public class ConditionFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public ConditionFormSQLParser( Condition element)
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
		if ( !(this.getQueryDefineElement() instanceof Condition))
		{
			throw new Exception(" ConditionFormSQLParser only parse Condition");
		}
		result = true;
		return result;
	}
}