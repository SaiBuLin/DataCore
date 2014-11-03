package org.zml.schema.parser.sql;
import org.zml.schema.bind.PageFactory;
public class PageFactorySQLParser extends SQLParser implements SQLParserAble
{
	public PageFactorySQLParser( PageFactory element)
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
		if ( !(this.getQueryDefineElement() instanceof PageFactory))
		{
			throw new Exception(" PageFactorySQLParser only parse PageFactory");
		}
		result = true;
		return result;
	}
}