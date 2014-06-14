package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.TransactionForm;
import org.zml.data.vo.exception.DataServiceException;

import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class TransactionFormSQLParser extends SQLParser implements SQLParserAble
{
	public TransactionFormSQLParser( TransactionForm element)
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
		if ( !(this.getQueryDefineElement() instanceof TransactionForm))
		{
			throw new Exception(" TransactionFormSQLParser only parse TransactionForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("TransactionFormSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("TransactionFormSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			TransactionForm config = (TransactionForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("TransactionFormSQLParser错误：loadSchemas, queryDefineElement构型为TransactionForm错误。" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("TransactionFormSQLParser 的ActionTools 配置为空，无法进行数据服务。");
			}
		
			if( config.getForm() != null ){
				SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter(  config.getForm()  );
				if( formAble != null ){
					formAble.loadSchemas(schema, properties);
				}else{
					logger.error("TransactionForm 的form创建PraserAble 失败。");
				}
			}else{
				logger.error("TransactionForm 的form没有配置。");
			}
			
			logger.debug("TransactionFormSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("TransactionFormSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("TransactionFormSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("TransactionFormSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

}