package org.zml.data.vo.parser;

import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SelectForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class SelectFormSQLParser extends SQLParser implements SQLParserAble
{
	
	public SelectFormSQLParser( SelectForm element)
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
		if ( !(this.getQueryDefineElement() instanceof SelectForm))
		{
			throw new Exception(" SelectFormSQLParser only parse SelectForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("SelectFormSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("SelectFormSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			SelectForm config = (SelectForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("SelectFormSQLParser错误：loadSchemas, queryDefineElement构型为SelectForm错误。" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("SelectForm 的ActionTools 配置为空，无法进行数据服务。");
			}
			
			if( config.getDataSet() != null ){
				SQLParserAble DataSetAble = SQLParserFactory.getQueryDefineInterpreter(config.getDataSet());
				if( DataSetAble != null ){
					DataSetAble.loadSchemas(schema, properties);
				}else{
					logger.error("SelectForm 的DataSet创建PraserAble 失败。");
				}
			}else{
				logger.error("SelectForm 的DataSet没有配置。");
			}
		
			logger.debug("SelectFormSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectFormSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SelectFormSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectFormSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	

	@Override 
	public void loadFieldsProperties( FieldsConfig fieldProperties) throws DataServiceException{
		try{
			logger.debug("SelectFormSQLParser开始执行loadFieldsProperties。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return;
			}
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties 入口参数fieldProperties为空。");
			}
			
			SelectForm config = (SelectForm)this.queryDefineElement;
			
				
			logger.debug("SelectFormSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectFormSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SelectFormSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectFormSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

	
}