package org.zml.schema.parser.sql;
import java.util.List;
import java.util.Map;

import org.zml.schema.bind.Attribute;
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
	public Map<String, Object> getAttributes() throws Exception{
		logger.error("Attribute�ǳ���������ʵ����ʹ�á�");
		return null;
	}
	
	@Override
	public List<Object> getAttribute(String attrname ) throws Exception{
		logger.error("Attribute�ǳ���������ʵ����ʹ�á�");
		return null;
	}
	
	@Override
	public void setAttribute(String attrname, Object value) throws Exception{
		logger.error("Attribute�ǳ���������ʵ����ʹ�á�");
	}
	
	@Override
	public void clear() throws Exception{
		logger.error("Attribute�ǳ���������ʵ����ʹ�á�");		
	}
	
	@Override
	public void deleteAttribute(String attrname)throws Exception{
		logger.error("Attribute�ǳ���������ʵ����ʹ�á�");		
	}
}