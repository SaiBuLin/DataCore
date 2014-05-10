package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.SQLSource;
public class SQLSourceFormsetParser extends FormsetParser implements FormsetParserAble
{
	public SQLSourceFormsetParser( SQLSource element)
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
			throw new Exception(" SQLSourceFormsetParser only parse SQLSource");
		}
		result = true;
		return result;
	}
}