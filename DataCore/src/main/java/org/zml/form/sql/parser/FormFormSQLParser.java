package org.zml.form.sql.parser;
import org.zml.form.bind.Form;
public class FormFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public FormFormSQLParser( Form element)
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
		if ( !(this.getQueryDefineElement() instanceof Form))
		{
			throw new Exception(" FormFormSQLParser only parse Form");
		}
		result = true;
		return result;
	}
}