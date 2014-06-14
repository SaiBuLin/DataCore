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
			logger.debug("ServiceFieldSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			if( config == null ){
				throw new Exception("强制转换到 错误。");
			}
			
			if( config.getStatus() != null ){
				SQLParserAble statusAble = SQLParserFactory.getQueryDefineInterpreter(config.getStatus() );
				if( statusAble != null ){
					statusAble.loadSchemas(schema, properties);
				}else{
					logger.error("ServiceField的status 没有能创建对应SQLParserAble.");
				}
			}else{
				logger.error("ServiceField 没有配置Status.");
			}
			
			
			logger.debug("ServiceFieldSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				
				logger.error("ServiceFieldSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException{
		
		try{
			logger.debug("ServiceFieldSQLParser开始执行LoadVODefine。");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties的入口参数fieldProperties为空。");
			}
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			if( config == null ){
				throw new Exception("强制转换到 错误。");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			
			if(UtilTools.isNull(code)){
				throw new Exception("ServiceField 必须配置code.");
			}
			
			fieldProperties.put(code, config);
			
			
			logger.debug("ServiceFieldSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				
				logger.error("ServiceFieldSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	
}