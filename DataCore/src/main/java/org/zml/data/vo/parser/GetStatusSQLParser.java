package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.GetStatus;
import org.zml.data.vo.bind.Schema;
import org.zml.util.UtilTools;

public class GetStatusSQLParser extends SQLParser implements SQLParserAble
{
	public GetStatusSQLParser( GetStatus element)
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
		if ( !(this.getQueryDefineElement() instanceof GetStatus))
		{
			throw new Exception(" GetStatusSQLParser only parse GetStatus");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("GetStatusSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("GetStatusSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			GetStatus config = (GetStatus)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement 转换成GetStatus错误。 ");
			}
			
			if( config.getLibrary() == null ){
				logger.error("getStatus 没有配置对应的Library.");
				return;
			}
			
			SQLParserAble libraryAble = SQLParserFactory.getQueryDefineInterpreter(config.getLibrary());
			if( libraryAble == null ){
				logger.error("getStatus的Library 没有配置对应的SQLParserAble.");
				return;
			}
			libraryAble.loadSchemas(schema, properties);
			
			logger.debug("GetStatusSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("GetStatusSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("GetStatusSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("GetStatusSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
}