package org.zml.data.vo.parser;

import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SelectForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
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
			
			if( config.getFormPart() != null ){
				SQLParserAble formparstAble = SQLParserFactory.getQueryDefineInterpreter(config.getFormPart());
				if( formparstAble != null ){
					formparstAble.loadSchemas(schema, properties);
				}else{
					logger.error("SelectForm 的FormPart创建PraserAble 失败。");
				}
			}else{
				logger.error("SelectForm 的FormPart没有配置。");
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
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		CommandForm result = new CommandForm();		
		try{
			
			logger.debug("SelectFormSQLParser开始执行parserCommand。");	
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			SelectForm config = (SelectForm)this.queryDefineElement;
			
			if( config == null){			
				throw new Exception("SelectFormSQLParser错误：parserCommand, queryDefineElement构型为SelectForm错误。" );
			}
			
			if( config.getFormPart() == null){
				throw new Exception("SelectFormSQLParser错误：parserCommand, FormPart没有配置。" );
			}
			
			if( config.getDataSet() == null){
				throw new Exception("SelectFormSQLParser错误：parserCommand, DataSet没有配置。" );
			}
			
			if( config.getActionTools() == null ){
				throw new Exception("SelectFormSQLParser错误：parserCommand, ActionTools没有配置。" );
			}
			
			SQLParserAble partAble = SQLParserFactory.getQueryDefineInterpreter(config.getFormPart() );
			
			if( partAble == null){
				throw new Exception("SelectFormSQLParser错误：parserCommand, FormPart不能正确对应正确的PraserTools。"  );
			}
			
			SQLParserAble dataSetAble = SQLParserFactory.getQueryDefineInterpreter(config.getDataSet() );
			if( dataSetAble == null){
				throw new Exception("SelectFormSQLParser错误：parserCommand, DataSet不能正确对应正确的PraserTools。"  );
			}
			
			CommandForm dataset = dataSetAble.parserDataSetStringCommand(form);
			if( dataset == null ){
				throw new Exception("DataSet没有指定，或者指定错误。");
			}
			
			CommandForm selectForm = partAble.parserSelectCommand(
					DATA_MODE_FOR_SELECT,dataset.getAlias(), form);
			
			CommandForm whereForm =  partAble.parserWhereCommand(
					DATA_MODE_FOR_SELECT,dataset.getAlias(), form);
			
			CommandForm orderForm =  partAble.parserOrderCommand(
					DATA_MODE_FOR_SELECT,
					dataset.getAlias(), form);
			
			CommandForm groupbyForm = partAble.parserGroupbyCommand(
					DATA_MODE_FOR_SELECT,
					dataset.getAlias(), form);
			
		
			//if( config.getFormPart() )
			SQLParserAble actionToolsAble = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if( actionToolsAble == null){
				throw new Exception("SelectFormSQLParser错误：parserCommand, ActionTools不能正确对应正确的PraserTools。"  );
			}
			
			if( form.getFormActionTools() == null ){
				IActionTools iaction = actionToolsAble.parseFormActionTools();
				form.setFormActionTools(iaction);
			}
			
			/* 生成Select对应命令字 */
			result = actionToolsAble.parserCommand(
					DATA_MODE_FOR_SELECT,
					form,
					selectForm,
					whereForm,
					orderForm,
					groupbyForm,
					dataset
					);
			
			logger.debug("SelectFormSQLParser执行parserCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectFormSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SelectFormSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectFormSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		
		return null;
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
			
			if( config.getFormPart() == null ){
				throw new Exception("SelectForm 的属性formPart 没有配置。");
			}
			
			SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( config.getFormPart() );
			if( formpartAble == null ){
				throw new Exception("Select的属性formPart没有对应的ParserTools类。");
			}
			
			formpartAble.loadFieldsProperties(fieldProperties);
			
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

	
	@Override
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException{
		NetDataSet result = null;
		/* VO Schema  */
		try{
			logger.debug("SelectFormSQLParser 执行executeVOAction。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* 强制转换 */
			logger.debug("executeVOAction 执行：将queryDefineElement强制转换成SelectForm.");
			SelectForm config = (SelectForm)this.getQueryDefineElement();
			
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
				logger.error("SelectForm没有配置ActionTools。");
				return result;
			}
			
			SQLParserAble actionParser = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if(actionParser == null ){
				logger.error("SelectForm 配置ActionTools创建SQLParserAble错误。");
				return result;
			}
			
			IActionTools actionTools = actionParser.parseFormActionTools();
			
			if( actionTools == null ){
				logger.error("SelectForm 配置ActionTools创建SQLParserAble执行parseFormActionTools错误。");
				return result;
			}
			
			IFormActionTools formTools = (IFormActionTools)actionTools ;
			
			IConnectionAble connection = actionParser.parseConnection();
			
			result = formTools.executeQuery(connection, form, formCommand);
			
			logger.debug("SelectFormSQLParser 执行executeVOAction完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectFormSQLParser::executeVOAction 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SelectFormSQLParser::executeVOAction 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectFormSQLParser::executeVOAction 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}