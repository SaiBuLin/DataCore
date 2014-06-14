package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.FormSet;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class FormSetSQLParser extends SQLParser implements SQLParserAble
{
	public FormSetSQLParser( FormSet element)
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
		if ( !(this.getQueryDefineElement() instanceof FormSet))
		{
			throw new Exception(" FormSetSQLParser only parse FormSet");
		}
		result = true;
		return result;
	}
	
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("FormSetSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("FormSetSQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			FormSet config = (FormSet)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement 转换成FormSet错误。 ");
			}
			
			if( config.getForm() == null ){
				logger.error("FormSet 没有配置对应的form.");
				return;
			}
			
			SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter(config.getForm());
			if( formAble == null ){
				logger.error("FormSet的form 没有配置对应的SQLParserAble.");
				return;
			}
			formAble.loadSchemas(schema, properties);
			
			logger.debug("FormSetSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormSetSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormSetSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormSetSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
}