package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.service.page.request.parser.VOServiceRequestAble;
import org.zml.data.service.page.request.parser.VOServiceRequestFactory;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.WherePart;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class WherePartSQLParser extends SQLParser implements SQLParserAble
{
	public WherePartSQLParser( WherePart element)
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
		if ( !(this.getQueryDefineElement() instanceof WherePart))
		{
			throw new Exception(" WherePartSQLParser only parse WherePart");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("WherePartSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("WherePartSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			WherePart config = (WherePart)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement 转换成WherePart错误。 ");
			}
			
			if( config.getField() == null ){
				logger.error("WherePart 没有配置对应的field.");
				return;
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(config.getField());
			if( fieldAble == null ){
				logger.error("WherePart的field 没有配置对应的SQLParserAble.");
				return;
			}
			fieldAble.loadSchemas(schema, properties);
			
			logger.debug("WherePartSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("WherePartSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("WherePartSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("WherePartSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		try{
			
			logger.debug("WherePartSQLParser开始执行LoadVODefine。");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties的入口参数fieldProperties为空。");
			}
			
			WherePart config = (WherePart)this.queryDefineElement;
			if( config == null ){
				throw new Exception("强制转换到 错误。");
			}
			
			if( fieldProperties.getWhereFields() == null ){
				fieldProperties.setWhereFields(new HashMap<String,Object>());
			}
			
			if( config.getField() == null ){
				throw new Exception("WherePart 没有配置对应Field.");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("WherePart 配置的Field 没有对应的ParserTools.");
			}
			
			fieldAble.loadFieldsProperties(fieldProperties.getWhereFields());
			
			
			logger.debug("WherePartSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("WherePartSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				
				logger.error("WherePartSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("WherePartSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

	@Override
	public CommandForm parserWhereCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("WherePartSQLParser开始执行parserWhereCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			if( form == null){
				throw new Exception("Where 条件生成需要输入form.");
			}
			
			WherePart config = (WherePart)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("WherePart 的属性field 没有配置。");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("WherePartSQLParser错误：parserWhereCommand, field不能正确对应正确的PraserTools。"  );
			}
			
			result  = fieldAble.parserWhereCommand(index, alias, form);
			
			if( result == null){
				throw new Exception("根据VOForm ParserWhereCommand失败。");
			}
			
			if(  result.getCommand() == null ){
				throw new Exception("根据VOForm ParserWhereCommand,其中Command的内容为空。");
			}
			
			
			
			String WhereString = "";// UtilTools.getTrim( result.getCommand() );
			
			/* 根据字符','来分解 */
			String[] whereFields = splitString( WhereString, ",");
			String command = "";
			if( form.getQueryRequestService() != null ){
				VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
				if( requestAble == null ){
					return result;
				}
				command = requestAble.parseWhereForSyntax(form, alias, whereFields);
			}
			
			result = new CommandForm();
			
			CommandConfiguration commandInfo = new CommandConfiguration();
			//result.setCommand(command);
			
			result.setCommand( commandInfo );
			
			result.setAlias(alias);
			//form.getQueryRequestService()
			
			logger.debug("WherePartSQLParser执行parserWhereCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("WherePartSQLParser::parserWhereCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("WherePartSQLParser::parserWhereCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("WherePartSQLParser::parserWhereCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}