package org.zml.data.vo.parser;
import java.util.Map;


import org.zml.data.vo.bind.ValueAttribute;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class ValueAttributeSQLParser extends SQLParser implements SQLParserAble
{
	public ValueAttributeSQLParser( ValueAttribute element)
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
		if ( !(this.getQueryDefineElement() instanceof ValueAttribute))
		{
			throw new Exception(" ValueAttributeSQLParser only parse ValueAttribute");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException{
		try{
			logger.debug("ValueAttributeSQLParser��ʼִ��loadProperties��");
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			if( properties == null ){
				throw new Exception( "loadProperties����ڲ���propertiesΪ�ա�" );
			}
			
			ValueAttribute config = (ValueAttribute)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception( "ValueAttributeǿ��ת������" );
			}
			
			String key = UtilTools.getTrim( config.getCode());
			
			if(UtilTools.isNull( key )){
				throw new Exception("ValueAttribute ������Code û�����á�");
			}
			logger.debug("ValueAttributeSQLParser װ�����ԡ�");
			
			properties.put( key,  config );
			
			logger.debug("ValueAttributeSQLParserִ��loadProperties��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ValueAttributeSQLParser::loadProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ValueAttributeSQLParser::loadProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ValueAttributeSQLParser::loadProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

}