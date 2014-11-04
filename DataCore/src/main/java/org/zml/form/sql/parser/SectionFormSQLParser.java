package org.zml.form.sql.parser;
import org.zml.form.bind.Section;
public class SectionFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public SectionFormSQLParser( Section element)
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
		if ( !(this.getQueryDefineElement() instanceof Section))
		{
			throw new Exception(" SectionFormSQLParser only parse Section");
		}
		result = true;
		return result;
	}
}