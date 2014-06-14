package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.DataForm;
import org.zml.data.vo.bind.InsertForm;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class InsertFormSQLParser extends SQLParser implements SQLParserAble
{
	public InsertFormSQLParser( InsertForm element)
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
		if ( !(this.getQueryDefineElement() instanceof InsertForm))
		{
			throw new Exception(" InsertFormSQLParser only parse InsertForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("InsertFormSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("InsertFormSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			InsertForm config = (InsertForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("InsertFormSQLParser错误：loadSchemas, queryDefineElement构型为InsertForm错误。" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("InsertFormSQLParser 的ActionTools 配置为空，无法进行数据服务。");
			}
			
			if( config.getDataSet() != null ){
				SQLParserAble DataSetAble = SQLParserFactory.getQueryDefineInterpreter(config.getDataSet());
				if( DataSetAble != null ){
					DataSetAble.loadSchemas(schema, properties);
				}else{
					logger.error("InsertForm 的DataSet创建PraserAble 失败。");
				}
			}else{
				logger.error("InsertForm 的DataSet没有配置。");
			}
		
			logger.debug("InsertFormSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("UpdateFormSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("UpdateFormSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("UpdateFormSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	
}