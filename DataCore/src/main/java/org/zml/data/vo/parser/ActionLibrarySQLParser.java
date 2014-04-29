package org.zml.data.vo.parser;

import org.zml.data.vo.bind.ActionLibrary;

public class ActionLibrarySQLParser extends SQLParser implements SQLParserAble
{
	public ActionLibrarySQLParser( ActionLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof ActionLibrary))
		{
			throw new Exception(" ActionLibrarySQLParser only parse ActionLibrary");
		}
		result = true;
		return result;
	}
}