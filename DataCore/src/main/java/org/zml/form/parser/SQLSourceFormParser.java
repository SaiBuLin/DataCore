package org.zml.form.parser;
import org.zml.form.bind.SQLSource;
public class SQLSourceFormParser extends FormParser implements FormParserAble
{
	public SQLSourceFormParser( SQLSource element)
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
		if ( !(this.getQueryDefineElement() instanceof SQLSource))
		{
			throw new Exception(" SQLSourceFormParser only parse SQLSource");
		}
		result = true;
		return result;
	}
}