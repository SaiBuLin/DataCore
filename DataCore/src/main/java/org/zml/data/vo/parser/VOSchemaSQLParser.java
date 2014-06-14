package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.Form;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.VOSchema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class VOSchemaSQLParser extends SQLParser implements SQLParserAble
{
	public VOSchemaSQLParser( VOSchema element)
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
		if ( !(this.getQueryDefineElement() instanceof VOSchema))
		{
			throw new Exception(" VOSchemaSQLParser only parse VOSchema");
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
		
		try{
			logger.debug("VOSchemaSQLParser 执行loadSchemas。");
			
			if( schema_map == null ){
				throw new NullPointerException("入口参数schema_map 定义的输入参数为空。");
			}
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			
			/* 强制转换 */
			logger.debug("loadSchemas 执行：将queryDefineElement强制转换成VOSchema.");
			VOSchema config = (VOSchema)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("强制转换错误。queryDefineElement 不能转换成VOSchema。");
			}
			
			if( UtilTools.isNull( config.getCode()) ){
				throw new Exception("VOSchema 必须配置code.");
			}
			
			String indexCode = UtilTools.getTrim(  config.getCode() );
			
			logger.debug("loadSchemas 执行：将VOSchema 读取出来.");
			if( config.getForm() == null ){
				throw new NullPointerException("Form定义 没有发现。");
			}
			
			logger.debug("loadSchemas 执行：将Schema 交给Parser 进行处理。.");
			
			SQLParserAble able = SQLParserFactory.getQueryDefineInterpreter( config.getForm() );
			if( able == null ){
				throw new ClassNotFoundException("Schema 的SQLParser 没有指定。");
			}
			
			Map<String, Object> privateproperties = new HashMap<String, Object>();
			if( properties != null ){
				privateproperties.putAll( properties );
			}
			if( config.getActionTools() != null ){
				privateproperties.put(PROPERTY_KEY_ACTION_TOOL, config.getActionTools());
			}
			
			Map<String, Map<String,Form>> privatevo_map  = new HashMap<String, Map<String,Form>>();
			Map<String,Form> intelMap = new HashMap<String,Form>();
			privatevo_map.put(indexCode, intelMap );
			
			/* 装载VO 定义 */
			able.loadSchemas(config, privateproperties);
			
			schema_map.put(indexCode,config);
			logger.debug("VOSchemaSQLParser 执行loadSchemas完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("VOSchemaSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("VOSchemaSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("VOSchemaSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

	
}