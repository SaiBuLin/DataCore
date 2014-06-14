package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.ViewForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class ViewFormSQLParser extends SQLParser implements SQLParserAble
{
	public ViewFormSQLParser( ViewForm element)
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
		if ( !(this.getQueryDefineElement() instanceof ViewForm))
		{
			throw new Exception(" ViewFormSQLParser only parse ViewForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("ViewFormSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("ViewFormSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			ViewForm config = (ViewForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("ViewFormSQLParser错误：loadSchemas, queryDefineElement构型为ViewForm错误。" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("ViewFormSQLParser 的ActionTools 配置为空，无法进行数据服务。");
			}
		
			if( config.getLeft() != null ){
				SQLParserAble leftarstAble = SQLParserFactory.getQueryDefineInterpreter(  config.getLeft()  );
				if( leftarstAble != null ){
					leftarstAble.loadSchemas(schema, properties);
				}else{
					logger.error("ViewForm 的Left创建PraserAble 失败。");
				}
			}else{
				logger.error("ViewForm 的Left没有配置。");
			}
			
			if( config.getRight() != null ){
				SQLParserAble leftarstAble = SQLParserFactory.getQueryDefineInterpreter(  config.getRight()  );
				if( leftarstAble != null ){
					leftarstAble.loadSchemas(schema, properties);
				}else{
					logger.error("ViewForm 的right创建PraserAble 失败。");
				}
			}else{
				logger.error("ViewForm 的right没有配置。");
			}
			
			logger.debug("ViewFormSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ViewFormSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ViewFormSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ViewFormSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	

	@Override 
	public void loadFieldsProperties( FieldsConfig fieldProperties) throws DataServiceException{
		try{
			logger.debug("ViewFormSQLParser开始执行loadFieldsProperties。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return;
			}
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties 入口参数fieldProperties为空。");
			}
			
			ViewForm config = (ViewForm)this.queryDefineElement;
			
			if( config.getLeft() == null ){
				throw new Exception("SelectForm 的属性left 没有配置。");
			}
			
			SQLParserAble leftAble = SQLParserFactory.getQueryDefineInterpreter( config.getLeft() );
			if( leftAble == null ){
				throw new Exception("Select的属性left没有对应的ParserTools类。");
			}
			
			if( config.getRight() == null ){
				throw new Exception("SelectForm 的属性right 没有配置。");
			}
			
			SQLParserAble rightAble = SQLParserFactory.getQueryDefineInterpreter( config.getRight() );
			if( rightAble == null ){
				throw new Exception("Select的属性right没有对应的ParserTools类。");
			}
			
			leftAble.loadFieldsProperties(fieldProperties);
			
			rightAble.loadFieldsProperties(fieldProperties);
			
			logger.debug("ViewFormSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ViewFormSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ViewFormSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ViewFormSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

	
}