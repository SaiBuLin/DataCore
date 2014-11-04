package org.zml.form.sql.parser;
import org.zml.form.bind.SQLFormService;
public class SQLFormServiceFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public SQLFormServiceFormSQLParser( SQLFormService element)
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
		if ( !(this.getQueryDefineElement() instanceof SQLFormService))
		{
			throw new Exception(" SQLFormServiceFormSQLParser only parse SQLFormService");
		}
		result = true;
		return result;
	}
}