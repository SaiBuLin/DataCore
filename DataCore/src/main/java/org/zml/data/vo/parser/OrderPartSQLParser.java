package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.bind.OrderPart;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class OrderPartSQLParser extends SQLParser implements SQLParserAble
{
	public OrderPartSQLParser( OrderPart element)
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
		if ( !(this.getQueryDefineElement() instanceof OrderPart))
		{
			throw new Exception(" OrderPartSQLParser only parse OrderPart");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("OrderPartSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("OrderPartSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			OrderPart config = (OrderPart)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement 转换成OrderPart错误。 ");
			}
			
			if( config.getField() == null ){
				logger.error("OrderPart 没有配置对应的field.");
				return;
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(config.getField());
			if( fieldAble == null ){
				logger.error("OrderPart的field 没有配置对应的SQLParserAble.");
				return;
			}
			fieldAble.loadSchemas(schema, properties);
			
			logger.debug("OrderPartSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("OrderPartSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("OrderPartSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("OrderPartSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		try{
			
			logger.debug("OrderPartSQLParser开始执行LoadVODefine。");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties的入口参数fieldProperties为空。");
			}
			
			OrderPart config = (OrderPart)this.queryDefineElement;
			if( config == null ){
				throw new Exception("强制转换到 错误。");
			}
			
			if( fieldProperties.getOrderFields() == null ){
				fieldProperties.setOrderFields(new HashMap<String,Object>());
			}
			
			if( config.getField() == null ){
				throw new Exception("OrderPart 没有配置对应Field.");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("OrderPart 配置的Field 没有对应的ParserTools.");
			}
			
			fieldAble.loadFieldsProperties(fieldProperties.getOrderFields());
			
			
			logger.debug("OrderPartSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("OrderPartSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				
				logger.error("OrderPartSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("OrderPartSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

	@Override
	public CommandForm parserOrderCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("OrderPartSQLParser开始执行parserOrderCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			OrderPart config = (OrderPart)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("OrderPart 的属性field 没有配置。");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("parserOrderCommand, field不能正确对应正确的PraserTools。"  );
			}
			result  = fieldAble.parserOrderCommand(index, alias, form);
			logger.debug("OrderPartSQLParser执行parserOrderCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("OrderPartSQLParser::parserOrderCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("OrderPartSQLParser::parserOrderCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("OrderPartSQLParser::parserOrderCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}