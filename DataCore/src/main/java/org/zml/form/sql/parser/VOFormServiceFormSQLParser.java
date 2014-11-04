package org.zml.form.sql.parser;
import org.zml.form.bind.VOFormService;
public class VOFormServiceFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public VOFormServiceFormSQLParser( VOFormService element)
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
		if ( !(this.getQueryDefineElement() instanceof VOFormService))
		{
			throw new Exception(" VOFormServiceFormSQLParser only parse VOFormService");
		}
		result = true;
		return result;
	}
}