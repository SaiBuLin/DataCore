package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SetStatus;
import org.zml.util.UtilTools;

public class SetStatusSQLParser extends SQLParser implements SQLParserAble
{
	public SetStatusSQLParser( SetStatus element)
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
		if ( !(this.getQueryDefineElement() instanceof SetStatus))
		{
			throw new Exception(" SetStatusSQLParser only parse SetStatus");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("SetStatusSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("SetStatusSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			SetStatus config = (SetStatus)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement 转换成SetStatus错误。 ");
			}
			
			if( config.getLibrary() == null ){
				logger.error("SetStatus 没有配置对应的Library.");
				return;
			}
			
			SQLParserAble libraryAble = SQLParserFactory.getQueryDefineInterpreter(config.getLibrary());
			if( libraryAble == null ){
				logger.error("SetStatus的Library 没有配置对应的SQLParserAble.");
				return;
			}
			libraryAble.loadSchemas(schema, properties);
			
			logger.debug("SetStatusSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SetStatusSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SetStatusSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SetStatusSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
}