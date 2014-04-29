package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SelectedPart;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class SelectedPartSQLParser extends SQLParser implements SQLParserAble
{
	public SelectedPartSQLParser( SelectedPart element)
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
		if ( !(this.getQueryDefineElement() instanceof SelectedPart))
		{
			throw new Exception(" SelectedPartSQLParser only parse SelectedPart");
		}
		result = true;
		return result;
	}
	
	@Override
	public CommandForm parserSelectCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("SelectedPartSQLParser开始执行parserSelectCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			SelectedPart config = (SelectedPart)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("SelectedPart 的属性field 没有配置。");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("SelectedPartSQLParser错误：parserSelectCommand, field不能正确对应正确的PraserTools。"  );
			}
			result  = fieldAble.parserSelectCommand(index, alias, form);
			logger.debug("SelectedPartSQLParser执行parserSelectCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectedPartSQLParser::parserSelectCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SelectedPartSQLParser::parserSelectCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectedPartSQLParser::parserSelectCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("SelectedPartSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("SelectedPartSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			SelectedPart config = (SelectedPart)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement 转换成SelectedPart错误。 ");
			}
			
			if( config.getField() == null ){
				logger.error("SelectedPart 没有配置对应的field.");
				return;
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(config.getField());
			if( fieldAble == null ){
				logger.error("SelectedPart的field 没有配置对应的SQLParserAble.");
				return;
			}
			fieldAble.loadSchemas(schema, properties);
			
			logger.debug("SelectedPartSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectedPartSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SelectedPartSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectedPartSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		try{
			
			logger.debug("SelectedPartSQLParser开始执行LoadVODefine。");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties的入口参数fieldProperties为空。");
			}
			
			SelectedPart config = (SelectedPart)this.queryDefineElement;
			if( config == null ){
				throw new Exception("强制转换到 错误。");
			}
			
			if( fieldProperties.getSelectFields() == null ){
				fieldProperties.setSelectFields(new HashMap<String,Object>());
			}
			
			if( config.getField() == null ){
				throw new Exception("SelectPart 没有配置对应Field.");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("SelectPart 配置的Field 没有对应的ParserTools.");
			}
			
			fieldAble.loadFieldsProperties(fieldProperties.getSelectFields());
			
			
			logger.debug("SelectedPartSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectedPartSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				
				logger.error("SelectedPartSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectedPartSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
}