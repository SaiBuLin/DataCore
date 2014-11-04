package org.zml.form.sql.parser;
import org.zml.form.bind.FormNode;
public class FormNodeFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public FormNodeFormSQLParser( FormNode element)
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
		if ( !(this.getQueryDefineElement() instanceof FormNode))
		{
			throw new Exception(" FormNodeFormSQLParser only parse FormNode");
		}
		result = true;
		return result;
	}
}