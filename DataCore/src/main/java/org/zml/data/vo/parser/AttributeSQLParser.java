package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.Attribute;
import org.zml.data.vo.exception.DataServiceException;

public class AttributeSQLParser extends SQLParser implements SQLParserAble
{
	public AttributeSQLParser( Attribute element)
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
		if ( !(this.getQueryDefineElement() instanceof Attribute))
		{
			throw new Exception(" AttributeSQLParser only parse Attribute");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException{
		logger.debug("Attributes是抽象类，不能实例化。");
	}
}