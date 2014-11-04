package org.zml.form.sql.parser;
import org.zml.form.bind.Column;
public class ColumnFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public ColumnFormSQLParser( Column element)
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
		if ( !(this.getQueryDefineElement() instanceof Column))
		{
			throw new Exception(" ColumnFormSQLParser only parse Column");
		}
		result = true;
		return result;
	}
}