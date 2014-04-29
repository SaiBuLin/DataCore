package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.FormSet;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
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
	public CommandForm parserDataSetStringCommand(VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			
			logger.debug("FormSetSQLParser开始执行parserCommand。");	
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FormSet config = (FormSet)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement构型为SQLSet错误。" );
			}
			
			if( config.getForm() == null ){
				throw new Exception("SQLSet必须配置Content，以作为命令。");
			}
			
			SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter( config.getForm() );
			if( formAble == null){
				throw new Exception(" FormSet的Form创建SQLParserAble错误。 ");
			}
			
			CommandForm formCommand = formAble.parserCommand(form);
			if( formCommand == null){
				return result;
			}
			
			if( formCommand.getCommand() == null){
				throw new Exception("FormSet的Form 在执行parserCommand生成CommandForm失败。");
			}
			
			result = new CommandForm();
			
			result.setAlias(UtilTools.getTrim(config.getAlias()));
			
			CommandConfiguration command = new CommandConfiguration();
			result.setCommand( command );
			//result.setCommand( UtilTools.getTrim( formCommand.getCommand() ) );
			
			logger.debug("FormSetSQLParser执行parserCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormSetSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormSetSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormSetSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
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