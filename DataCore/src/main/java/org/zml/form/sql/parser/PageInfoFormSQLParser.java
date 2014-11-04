package org.zml.form.sql.parser;
import org.zml.form.bind.PageInfo;
public class PageInfoFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public PageInfoFormSQLParser( PageInfo element)
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
		if ( !(this.getQueryDefineElement() instanceof PageInfo))
		{
			throw new Exception(" PageInfoFormSQLParser only parse PageInfo");
		}
		result = true;
		return result;
	}
}