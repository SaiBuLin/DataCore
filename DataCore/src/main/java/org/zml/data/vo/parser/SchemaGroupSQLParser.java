package org.zml.data.vo.parser;
import java.util.ArrayList;
import java.util.Map;

import org.zml.data.vo.bind.Form;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SchemaGroup;
import org.zml.util.UtilTools;

public class SchemaGroupSQLParser extends SQLParser implements SQLParserAble
{
	public SchemaGroupSQLParser( SchemaGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaGroup))
		{
			throw new Exception(" SchemaGroupSQLParser only parse SchemaGroup");
		}
		result = true;
		return result;
	}
	
	/**
	 * @see override interface 
	 * 
	 */
	@Override
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception{
		logger.debug("SchemaGroupSQLParser 执行loadSchemas。");
		try{
			if( schema_map == null ){
				throw new NullPointerException("VO 定义的输入参数为空。");
			}
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			/* 强制转换 */
			logger.debug("loadSchemas 执行：将queryDefineElement强制转换成SchemaGroup.");
			SchemaGroup config = (SchemaGroup)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("强制转换错误。queryDefineElement 不能转换成SchemaGroup。");
			}
			
			logger.debug("loadSchemas 执行：将Schema 读取出来.");
			if( config.getSchema() == null ){
				throw new NullPointerException("Schema 没有发现。");
			}
			
			
			logger.debug("loadSchemas 执行：将Schema组 交给Parser 进行处理。.");
			ArrayList<Schema> vodefines = config.getSchema();
			int mSize = vodefines.size();
			
			logger.debug("loadSchemas 执行：循环读取Schema.");
			for( int ii = 0; ii < mSize; ii++ ){
				Schema vodefine = vodefines.get(ii);
				if( vodefine == null ){
					logger.error("SchemaGroupSQLParser::loadSchemas 抛出异常， 异常：从Schema列表读取Schema 为NULL." );
					continue;
				}
				SQLParserAble able = SQLParserFactory.getQueryDefineInterpreter( vodefine );
				if( able == null ){
					logger.error("SchemaGroupSQLParser::loadSchemas 抛出异常， 异常：Schema Parser 错误。 类：" + vodefine.getClass().toString() );
					continue;
				}
				/* 装载VO 定义 */
				able.loadSchemas(schema_map, properties);
			}
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SchemaGroupSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SchemaGroupSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SchemaGroupSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
}