package org.zml.data.vo.parser;

import org.zml.data.vo.bind.ServiceForm;

public class ServiceFormSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceFormSQLParser( ServiceForm element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceForm))
		{
			throw new Exception(" ServiceFormSQLParser only parse ServiceForm");
		}
		result = true;
		return result;
	}
	
}