package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.Form;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SchemaConfigure;
import org.zml.util.UtilTools;

public class SchemaConfigureSQLParser extends SQLParser implements SQLParserAble
{
	public SchemaConfigureSQLParser( SchemaConfigure element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaConfigure))
		{
			throw new Exception(" SchemaConfigureSQLParser only parse SchemaConfigure");
		}
		result = true;
		return result;
	}
	
	/**
	 * @see override interface 
	 * 
	 */
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception{
		logger.debug("SchemaConfigureSQLParser 执行loadSchemas。");
		try{
			if( schema_map == null ){
				throw new NullPointerException("入口参数schema_map 定义的输入参数为空。");
			}
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			/* 强制转换 */
			logger.debug("loadSchemas 执行：将queryDefineElement强制转换成SchemaConfigure.");
			SchemaConfigure config = (SchemaConfigure)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("强制转换错误。queryDefineElement 不能转换成SchemaConfigure。");
			}
			
			logger.debug("loadSchemas 执行：将Schema 读取出来.");
			if( config.getSchema() == null ){
				throw new NullPointerException("Schema 没有发现。");
			}
			
			logger.debug("loadSchemas 执行：将Schema 交给Parser 进行处理。.");
			
			SQLParserAble able = SQLParserFactory.getQueryDefineInterpreter( config.getSchema() );
			if( able == null ){
				throw new ClassNotFoundException("Schema 的SQLParser 没有指定。");
			}
			
			/* 装载VO 定义 */
			able.loadSchemas(schema_map, properties);
			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SchemaConfigureSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SchemaConfigureSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SchemaConfigureSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
}