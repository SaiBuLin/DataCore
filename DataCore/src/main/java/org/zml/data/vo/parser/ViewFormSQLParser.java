package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.ViewForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
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
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		/* VIEW FORM　只支持ＳＱＬ　ＤＢ的数据访问 */
		CommandForm result = null;
		try{
			logger.debug("ViewFormSQLParser开始执行parserCommand。");
			
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ViewForm config = (ViewForm)this.queryDefineElement;
			if( config == null){			
				throw new DataServiceException("ViewFormSQLParser错误：parserCommand, queryDefineElement构型为ViewForm错误。" );
			}
		
			
			if( (config.getLeft() == null)
					&& ( config.getRight() == null )
					){
				throw new DataServiceException("ViewForm 配置的Left和Right 都为空。");
			}
			else if ( config.getRight() == null ){
				SQLParserAble leftAble = SQLParserFactory.getQueryDefineInterpreter(config.getLeft() ) ;
				
				if( leftAble == null ){
					throw new DataServiceException("ViewFormSQLParser错误：parserCommand, Left属性不能对应ParserTools." ); 
				}
				logger.debug("ActionTools 生成View 的命令字" );
				result = leftAble.parserCommand(form);
			}
			else if ( config.getLeft() == null ){
				SQLParserAble rightAble = SQLParserFactory.getQueryDefineInterpreter(config.getRight() ) ;
				
				if( rightAble == null ){
					throw new DataServiceException("ViewFormSQLParser错误：parserCommand, Right属性不能对应ParserTools." ); 
				}
				logger.debug("ActionTools 生成View 的命令字" );
				result = rightAble.parserCommand(form);
			}else {
				/* 装载FieldProperties */
				FieldsConfig fieldProperties = new FieldsConfig();
				
				this.loadFieldsProperties(fieldProperties);
				
				form.getProperties().put(PROPERTY_KEY_FIELDS, fieldProperties);
				
				SQLParserAble leftAble = SQLParserFactory.getQueryDefineInterpreter(config.getLeft() ) ;
				
				if( leftAble == null ){
					throw new DataServiceException("ViewFormSQLParser错误：parserCommand, Left属性不能对应ParserTools." ); 
				}
				
				SQLParserAble rightAble = SQLParserFactory.getQueryDefineInterpreter(config.getRight() ) ;
				
				if( rightAble == null ){
					throw new DataServiceException("ViewFormSQLParser错误：parserCommand, Right属性不能对应ParserTools." ); 
				}
				
				CommandForm leftForm = leftAble.parserCommand(form);
				
				CommandForm rightForm = rightAble.parserCommand(form);
				
				if( config.getRelation() == null ){
					throw new DataServiceException("ViewForm没有配置Relation." );
				}
				
				SQLParserAble relationAble = SQLParserFactory.getQueryDefineInterpreter( config.getRelation() ) ;
				
				if( relationAble == null ){
					throw new DataServiceException("ViewForm没有配置RelationShip没有对应的ParserTools." );
				}
				
				logger.debug("Relation 生成View 的命令字" );
				CommandForm realationForm = relationAble.parserCommand(
						form, 
						leftForm, rightForm, 
						config.getTableRelation() 
						);
				

				if( config.getActionTools() == null ){
					throw new DataServiceException("ViewForm没有配置ActionTools." );
				}	
				
				logger.debug("利用acionToolsAble 生成Command." );
				SQLParserAble actionToolsAble = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() ) ;
				
				if( actionToolsAble == null ){
					throw new DataServiceException("ViewForm没有配置ActionTools没有对应的ParserTools." );
				}

				if( form.getFormActionTools() == null ){
					IActionTools iaction = actionToolsAble.parseFormActionTools();
					form.setFormActionTools(iaction);
				}
				result = actionToolsAble.parserCommand(
						DATA_MODE_FOR_SELECT,
						form, 
						realationForm);
				
				if( form.getProperties().containsKey(PROPERTY_KEY_FIELDS)){
					form.getProperties().remove(PROPERTY_KEY_FIELDS );
				}
				
			}
			logger.debug("ActionTools 生成View 命令字的类容：" + result.getCommand() );
			logger.debug("ViewFormSQLParser执行parserCommand完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ViewFormSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ViewFormSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ViewFormSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
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

	@Override
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException{
		NetDataSet result = null;
		/* VO Schema  */
		try{
			logger.debug("ViewFormSQLParser 执行executeVOAction。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* 强制转换 */
			logger.debug("executeVOAction 执行：将queryDefineElement强制转换成ViewForm.");
			ViewForm config = (ViewForm)this.getQueryDefineElement();
			
			if( config == null ){
				return result;
			}
			
			if(UtilTools.isNull( config.getCode() )){
				logger.error("ViewForm的Code 没有配置。");
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
			
			logger.debug("执行VO的Form其中Form的编号为：" + tmpFormCode );
			
			/* 根据请求获得SQL 文 */
			CommandForm formCommand = this.parserCommand(form);
			
			if( formCommand == null ){
				logger.error("生成CommandForm错误。");
				return result;
			}
			
			if( config.getActionTools() == null ){
				logger.error("ViewForm没有配置ActionTools。");
				return result;
			}
			
			SQLParserAble actionParser = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if(actionParser == null ){
				logger.error("ViewForm配置ActionTools创建SQLParserAble错误。");
				return result;
			}
			
			IActionTools actionTools = actionParser.parseFormActionTools();
			
			if( actionTools == null ){
				logger.error("ViewForm配置ActionTools创建SQLParserAble执行parseFormActionTools错误。");
				return result;
			}
			
			IFormActionTools formTools = (IFormActionTools)actionTools ;
			
			IConnectionAble connection = actionParser.parseConnection();
			
			result = formTools.executeQuery(connection, form, formCommand);
			
			logger.debug("ViewFormSQLParser执行executeVOAction完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ViewFormSQLParser::executeVOAction 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ViewFormSQLParser::executeVOAction 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ViewFormSQLParser::executeVOAction 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}