package org.zml.form.sql.parser;
import org.zml.form.bind.ScriptColumn;
public class ScriptColumnFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public ScriptColumnFormSQLParser( ScriptColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof ScriptColumn))
		{
			throw new Exception(" ScriptColumnFormSQLParser only parse ScriptColumn");
		}
		result = true;
		return result;
	}
}