package org.zml.form.sql.parser;
import org.zml.form.bind.FormService;
public class FormServiceFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public FormServiceFormSQLParser( FormService element)
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
		if ( !(this.getQueryDefineElement() instanceof FormService))
		{
			throw new Exception(" FormServiceFormSQLParser only parse FormService");
		}
		result = true;
		return result;
	}
}