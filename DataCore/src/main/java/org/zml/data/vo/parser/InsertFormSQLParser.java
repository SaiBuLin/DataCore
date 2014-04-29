package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.DataForm;
import org.zml.data.vo.bind.InsertForm;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
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
			
			if( config.getFormPart() != null ){
				SQLParserAble formparstAble = SQLParserFactory.getQueryDefineInterpreter(config.getFormPart());
				if( formparstAble != null ){
					formparstAble.loadSchemas(schema, properties);
				}else{
					logger.error("InsertForm 的FormPart创建PraserAble 失败。");
				}
			}else{
				logger.error("InsertForm 的FormPart没有配置。");
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
	
	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		CommandForm result = new CommandForm();		
		try{
			
			logger.debug("InsertFormSQLParser开始执行parserCommand。");	
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* 判断是否DataForm */
			if(!( this.queryDefineElement instanceof DataForm ) ){
				return result;
			}
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			
			if( config == null){			
				throw new Exception("InsertFormSQLParser错误：parserCommand, queryDefineElement构型为SelectForm错误。" );
			}
			
			if( config.getFormPart() == null){
				throw new Exception("InsertFormSQLParser错误：parserCommand, FormPart没有配置。" );
			}
			
			if( config.getDataSet() == null){
				throw new Exception("InsertFormSQLParser错误：parserCommand, DataSet没有配置。" );
			}
			
			if( config.getActionTools() == null ){
				throw new Exception("InsertFormSQLParser错误：parserCommand, ActionTools没有配置。" );
			}
			
		
			SQLParserAble partAble = SQLParserFactory.getQueryDefineInterpreter(config.getFormPart() );
			
			if( partAble == null){
				throw new Exception("InsertFormSQLParser错误：parserCommand, FormPart不能正确对应正确的PraserTools。"  );
			}
			
			SQLParserAble dataSetAble = SQLParserFactory.getQueryDefineInterpreter(config.getDataSet() );
			if( dataSetAble == null){
				throw new Exception("InsertFormSQLParser错误：parserCommand, DataSet不能正确对应正确的PraserTools。"  );
			}
			
			CommandForm dataset = dataSetAble.parserDataSetStringCommand(form);
			if( dataset == null ){
				throw new Exception("DataSet没有指定，或者指定错误。");
			}
			
			CommandForm selectForm = partAble.parserSelectCommand( 
					DATA_MODE_FOR_INSERT,
					dataset.getAlias(),
					form );
			CommandForm whereForm =  partAble.parserWhereCommand(
					DATA_MODE_FOR_INSERT,
					dataset.getAlias(),form );
			CommandForm orderForm =  partAble.parserOrderCommand( 
					DATA_MODE_FOR_INSERT,
					dataset.getAlias(), 
					form );
			CommandForm groupbyForm =  partAble.parserGroupbyCommand( 
					DATA_MODE_FOR_INSERT,
					dataset.getAlias(), 
					form );
			
			
			
			//if( config.getFormPart() )
			SQLParserAble actionToolsAble = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if( actionToolsAble == null){
				throw new Exception("InsertFormSQLParser错误：parserCommand, ActionTools不能正确对应正确的PraserTools。"  );
			}
			
			if( form.getFormActionTools() == null ){
				IActionTools iaction = actionToolsAble.parseFormActionTools();
				form.setFormActionTools(iaction);
			}
			/* 生成Select对应命令字 */
			result = actionToolsAble.parserCommand(
					DATA_MODE_FOR_INSERT,
					form,
					selectForm,
					whereForm,
					orderForm,
					groupbyForm,
					dataset
					);
			
			logger.debug("InsertFormSQLParser执行parserCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("InsertFormSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("InsertFormSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("InsertFormSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
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
			logger.debug("InsertFormSQLParser 执行executeVOAction。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* 强制转换 */
			logger.debug("executeVOAction 执行：将queryDefineElement强制转换成InsertForm.");
			InsertForm config = (InsertForm)this.getQueryDefineElement();
			
			if( config == null ){
				return result;
			}
			
			if(UtilTools.isNull( config.getCode() )){
				logger.error("InsertForm 的Code 没有配置。");
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
				logger.error("InsertForm没有配置ActionTools。");
				return result;
			}
			
			SQLParserAble actionParser = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if(actionParser == null ){
				logger.error("InsertForm配置ActionTools创建SQLParserAble错误。");
				return result;
			}
			
			IActionTools actionTools = actionParser.parseFormActionTools();
			
			if( actionTools == null ){
				logger.error("InsertForm配置ActionTools创建SQLParserAble执行parseFormActionTools错误。");
				return result;
			}
			
			IFormActionTools formTools = (IFormActionTools)actionTools ;
			
			IConnectionAble connection = actionParser.parseConnection();
			
			result = formTools.executeInsert(connection, form, formCommand);
			
			logger.debug("InsertFormSQLParser 执行executeVOAction完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("InsertFormSQLParser::executeVOAction 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("InsertFormSQLParser::executeVOAction 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("InsertFormSQLParser::executeVOAction 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}