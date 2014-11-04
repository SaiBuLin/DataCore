package org.zml.form.sql.parser;
import org.zml.form.bind.FormGroup;
public class FormGroupFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public FormGroupFormSQLParser( FormGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FormGroup))
		{
			throw new Exception(" FormGroupFormSQLParser only parse FormGroup");
		}
		result = true;
		return result;
	}
}