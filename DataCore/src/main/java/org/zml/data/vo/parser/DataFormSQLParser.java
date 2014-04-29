package org.zml.data.vo.parser;

import org.zml.data.vo.bind.DataForm;

public class DataFormSQLParser extends SQLParser implements SQLParserAble
{

	public DataFormSQLParser( DataForm element)
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
		if ( !(this.getQueryDefineElement() instanceof DataForm))
		{
			throw new Exception(" DataFormSQLParser only parse DataForm");
		}
		result = true;
		return result;
	}
	
	
}