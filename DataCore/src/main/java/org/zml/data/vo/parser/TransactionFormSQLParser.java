package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.TransactionForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
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
	
	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("TransactionFormSQLParser开始执行parserCommand。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			TransactionForm config = (TransactionForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("TransactionFormSQLParser错误：parserCommand, queryDefineElement构型为TransactionForm错误。" );
			}
			
			if( config.getForm() == null ){
				throw new Exception("TransactionForm 没有配置Form.");
			}
			
			SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter( config.getForm() );
			if( formAble == null ){
				throw new Exception("TransactionForm的Form属性没有对应的ParserTools. ");
			}
			
			result = formAble.parserCommand(form);
			
			logger.debug("TransactionFormSQLParser执行parserCommand完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("TransactionFormSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("TransactionFormSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("TransactionFormSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}

	@Override
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException{
		NetDataSet result = null;
		/* VO Schema  */
		try{
			logger.debug("TransactionFormSQLParser 执行executeVOAction。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* 强制转换 */
			logger.debug("executeVOAction 执行：将queryDefineElement强制转换成TransactionForm.");
			TransactionForm config = (TransactionForm)this.getQueryDefineElement();
			
			if( config == null ){
				return result;
			}
			
			if(UtilTools.isNull( config.getCode() )){
				logger.error("SelectForm的Code 没有配置。");
				return result;
			}
			
			if( UtilTools.isNull(formcode) ){
				logger.error("入口参数FormCode 没有指定。");
				return result;
			}
			
			String tmpCode = UtilTools.getTrim( config.getCode() );
			
			String tmpFormCode = UtilTools.getTrim( formcode );
			
			if( !tmpFormCode.equalsIgnoreCase(tmpCode) ){
				return result;
			}
			
			logger.debug("执行VO 的Form 其中Form的编号为：" + tmpFormCode );
			
			/* 根据请求获得SQL 文 */
			CommandForm formCommand = this.parserCommand(form);
			
			if( formCommand == null ){
				logger.error("生成CommandForm错误。");
				return result;
			}
			
			if( config.getActionTools() == null ){
				logger.error("TransactionForm没有配置ActionTools。");
				return result;
			}
			
			SQLParserAble actionParser = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if(actionParser == null ){
				logger.error("TransactionForm配置ActionTools创建SQLParserAble错误。");
				return result;
			}
			
			IActionTools actionTools = actionParser.parseFormActionTools();
			
			if( actionTools == null ){
				logger.error("TransactionForm配置ActionTools创建SQLParserAble执行parseFormActionTools错误。");
				return result;
			}
			
			IFormActionTools formTools = (IFormActionTools)actionTools ;
			
			IConnectionAble connection = actionParser.parseConnection();
			
			result = formTools.executeQuery(connection, form, formCommand);
			
			logger.debug("TransactionFormSQLParser 执行executeVOAction完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("TransactionFormSQLParser::executeVOAction 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("TransactionFormSQLParser::executeVOAction 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("TransactionFormSQLParser::executeVOAction 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}