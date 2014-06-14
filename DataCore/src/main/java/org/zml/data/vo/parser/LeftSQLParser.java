package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.Left;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class LeftSQLParser extends SQLParser implements SQLParserAble
{
	public LeftSQLParser( Left element)
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
		if ( !(this.getQueryDefineElement() instanceof Left))
		{
			throw new Exception(" LeftSQLParser only parse Left");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("LeftSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("LeftSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			Left config = (Left)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement 转换成Left错误。 ");
			}
			
			if( config.getForm() == null ){
				logger.error("Left 没有配置对应的form.");
				return;
			}
			
			SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter(config.getForm());
			if( formAble == null ){
				logger.error("Left的form 没有配置对应的SQLParserAble.");
				return;
			}
			formAble.loadSchemas(schema, properties);
			
			logger.debug("LeftSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("LeftSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("LeftSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("LeftSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties( FieldsConfig fieldProperties) throws DataServiceException{
		try{
			logger.debug("LeftSQLParser开始执行loadFieldsProperties。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return;
			}
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties 入口参数fieldProperties为空。");
			}
			
			Left config = (Left)this.queryDefineElement;
			
			if( config.getForm() == null ){
				throw new Exception("Left 的属性form 没有配置。");
			}
			
			SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( config.getForm() );
			if( formpartAble == null ){
				throw new Exception("Left的属性form没有对应的ParserTools类。");
			}
			
			formpartAble.loadFieldsProperties(fieldProperties);
			
			logger.debug("LeftSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("LeftSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("LeftSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("LeftSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
}