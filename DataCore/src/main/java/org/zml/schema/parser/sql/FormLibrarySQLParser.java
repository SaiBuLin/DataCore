package org.zml.schema.parser.sql;
import org.zml.schema.bind.FormLibrary;
public class FormLibrarySQLParser extends SQLParser implements SQLParserAble
{
	public FormLibrarySQLParser( FormLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof FormLibrary))
		{
			throw new Exception(" FormLibrarySQLParser only parse FormLibrary");
		}
		result = true;
		return result;
	}
}