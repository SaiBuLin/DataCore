package org.zml.schema.parser.sql;
import org.zml.schema.bind.Form;
public class FormSQLParser extends SQLParser implements SQLParserAble
{
	public FormSQLParser( Form element)
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
			throw new Exception(" FormSQLParser only parse Form");
		}
		result = true;
		return result;
	}
}