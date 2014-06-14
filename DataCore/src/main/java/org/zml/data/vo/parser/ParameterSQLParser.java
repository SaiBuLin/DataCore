package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.Parameter;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class ParameterSQLParser extends SQLParser implements SQLParserAble
{
	public ParameterSQLParser( Parameter element)
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
		if ( !(this.getQueryDefineElement() instanceof Parameter))
		{
			throw new Exception(" ParameterSQLParser only parse Parameter");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException{
		try{
			logger.debug("ParameterSQLParser��ʼִ��loadProperties��");
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			if( properties == null ){
				throw new Exception( "loadProperties����ڲ���propertiesΪ�ա�" );
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception( "Parameterǿ��ת������" );
			}
			
			String key = UtilTools.getTrim( config.getCode());
			
			if(UtilTools.isNull( key )){
				throw new Exception("Parameter ������Code û�����á�");
			}
			logger.debug("ParameterSQLParser װ�����ԡ�");
			
			properties.put( key,  config );
			
			logger.debug("ParameterSQLParserִ��loadProperties��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ParameterSQLParser::loadProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ParameterSQLParser::loadProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ParameterSQLParser::loadProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	
}