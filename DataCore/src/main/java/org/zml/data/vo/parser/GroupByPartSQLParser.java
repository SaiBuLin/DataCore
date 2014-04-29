package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.bind.GroupByPart;
import org.zml.data.vo.bind.OrderPart;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class GroupByPartSQLParser extends SQLParser implements SQLParserAble
{
	public GroupByPartSQLParser( GroupByPart element)
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
		if ( !(this.getQueryDefineElement() instanceof GroupByPart))
		{
			throw new Exception(" GroupByPartSQLParser only parse GroupByPart");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("GroupByPartSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("GroupByPartSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			GroupByPart config = (GroupByPart)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement 转换成GroupByPart错误。 ");
			}
			
			if( config.getField() == null ){
				logger.error("GroupByPart 没有配置对应的field.");
				return;
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(config.getField());
			if( fieldAble == null ){
				logger.error("GroupByPart的field 没有配置对应的SQLParserAble.");
				return;
			}
			fieldAble.loadSchemas(schema, properties);
			
			logger.debug("GroupByPartSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("GroupByPartSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("GroupByPartSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("GroupByPartSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		try{
			
			logger.debug("GroupByPartSQLParser开始执行LoadVODefine。");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties的入口参数fieldProperties为空。");
			}
			
			GroupByPart config = (GroupByPart)this.queryDefineElement;
			if( config == null ){
				throw new Exception("强制转换到 错误。");
			}
			
			if( fieldProperties.getGroupbyFields() == null ){
				fieldProperties.setGroupbyFields(new HashMap<String,Object>());
			}
			
			if( config.getField() == null ){
				throw new Exception("GroupByPart 没有配置对应Field.");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("GroupByPart 配置的Field 没有对应的ParserTools.");
			}
			
			fieldAble.loadFieldsProperties(fieldProperties.getGroupbyFields());
			
			
			logger.debug("GroupByPartSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("GroupByPartSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				
				logger.error("GroupByPartSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("GroupByPartSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

	@Override
	public CommandForm parserGroupbyCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("GroupByPartSQLParser开始执行parserGroupbyCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			OrderPart config = (OrderPart)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("OrderPart 的属性field 没有配置。");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("parserGroupbyCommand, field不能正确对应正确的PraserTools。"  );
			}
			result  = fieldAble.parserGroupbyCommand(index, alias, form);
			logger.debug("GroupByPartSQLParser执行parserGroupbyCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("GroupByPartSQLParser::parserGroupbyCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("GroupByPartSQLParser::parserGroupbyCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("GroupByPartSQLParser::parserGroupbyCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
	
}

