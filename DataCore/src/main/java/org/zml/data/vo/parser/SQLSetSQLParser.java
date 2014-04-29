package org.zml.data.vo.parser;

import org.zml.data.vo.bind.SQLSet;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class SQLSetSQLParser extends SQLParser implements SQLParserAble
{
	public SQLSetSQLParser( SQLSet element)
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
		if ( !(this.getQueryDefineElement() instanceof SQLSet))
		{
			throw new Exception(" SQLSetSQLParser only parse SQLSet");
		}
		result = true;
		return result;
	}
	
	@Override
	public CommandForm parserDataSetStringCommand(VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			
			logger.debug("SQLSetSQLParser开始执行parserCommand。");	
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			SQLSet config = (SQLSet)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement构型为SQLSet错误。" );
			}
			
			if(UtilTools.isNull( config.getContent())){
				throw new Exception("SQLSet必须配置Content，以作为命令。");
			}
			
			result = new CommandForm();
			
			result.setAlias(UtilTools.getTrim(config.getAlias()));
			
			CommandConfiguration command = new CommandConfiguration();
			
			//result.setCommand( UtilTools.getTrim( config.getContent()  ) );
			
			result.setCommand( command );
			
			logger.debug("SQLSetSQLParser执行parserCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SQLSetSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("SQLSetSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SQLSetSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}