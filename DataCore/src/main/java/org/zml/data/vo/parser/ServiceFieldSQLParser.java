package org.zml.data.vo.parser;
import java.util.Map;


import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.ServiceField;
import org.zml.data.vo.exception.DataServiceException;

import org.zml.util.UtilTools;
          
public class ServiceFieldSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceFieldSQLParser( ServiceField element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceField))
		{
			throw new Exception(" ServiceFieldSQLParser only parse ServiceField");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("ServiceFieldSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			if( config == null ){
				throw new Exception("ǿ��ת���� ����");
			}
			
			if( config.getStatus() != null ){
				SQLParserAble statusAble = SQLParserFactory.getQueryDefineInterpreter(config.getStatus() );
				if( statusAble != null ){
					statusAble.loadSchemas(schema, properties);
				}else{
					logger.error("ServiceField��status û���ܴ�����ӦSQLParserAble.");
				}
			}else{
				logger.error("ServiceField û������Status.");
			}
			
			
			logger.debug("ServiceFieldSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				
				logger.error("ServiceFieldSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException{
		
		try{
			logger.debug("ServiceFieldSQLParser��ʼִ��LoadVODefine��");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties����ڲ���fieldPropertiesΪ�ա�");
			}
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			if( config == null ){
				throw new Exception("ǿ��ת���� ����");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			
			if(UtilTools.isNull(code)){
				throw new Exception("ServiceField ��������code.");
			}
			
			fieldProperties.put(code, config);
			
			
			logger.debug("ServiceFieldSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				
				logger.error("ServiceFieldSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	
}