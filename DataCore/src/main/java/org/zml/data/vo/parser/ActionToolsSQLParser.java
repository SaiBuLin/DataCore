package org.zml.data.vo.parser;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.exception.DataServiceException;

import org.zml.data.vo.tools.action.IFormActionTools;

public class ActionToolsSQLParser extends SQLParser implements SQLParserAble
{
	public ActionToolsSQLParser( ActionTools element)
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
		if ( !(this.getQueryDefineElement() instanceof ActionTools))
		{
			throw new Exception(" ActionToolsSQLParser only parse ActionTools");
		}
		result = true;
		return result;
	}
	
	@Override 
	public IFormActionTools parseFormActionTools() throws DataServiceException{
		throw new DataServiceException(" ActionTools  «≥ÈœÛ¿‡°£  ");
	}
	
}