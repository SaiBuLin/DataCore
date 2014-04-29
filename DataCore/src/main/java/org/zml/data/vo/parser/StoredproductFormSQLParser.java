package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.StoredproductForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class StoredproductFormSQLParser extends SQLParser implements SQLParserAble
{
	public StoredproductFormSQLParser( StoredproductForm element)
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
		if ( !(this.getQueryDefineElement() instanceof StoredproductForm))
		{
			throw new Exception(" StoredproductFormSQLParser only parse StoredproductForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("StoredproductFormSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("StoredproductFormSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			StoredproductForm config = (StoredproductForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("StoredproductFormSQLParser错误：loadSchemas, queryDefineElement构型为StoredproductForm错误。" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("StoredproductFormSQLParser 的ActionTools 配置为空，无法进行数据服务。");
			}
			
			logger.debug("StoredproductFormSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("StoredproductFormSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("StoredproductFormSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("StoredproductFormSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("StoredproductFormSQLParser开始执行parserCommand。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			StoredproductForm config = (StoredproductForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("StoredproductFormSQLParser错误：parserCommand, queryDefineElement构型为TransactionForm错误。" );
			}
			
			
			
			logger.debug("StoredproductFormSQLParser执行parserCommand完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("StoredproductFormSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("StoredproductFormSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("StoredproductFormSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}