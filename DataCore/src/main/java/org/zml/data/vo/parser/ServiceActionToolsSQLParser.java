package org.zml.data.vo.parser;
import java.util.HashMap;

import org.zml.data.vo.bind.ServiceActionTools;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.ServiceTask;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class ServiceActionToolsSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceActionToolsSQLParser( ServiceActionTools element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceActionTools))
		{
			throw new Exception(" ServiceActionToolsSQLParser only parse ServiceActionTools");
		}
		result = true;
		return result;
	}
	
	@Override 
	public IActionTools parseFormActionTools() throws DataServiceException{
		IActionTools result = null;
		try{
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ServiceActionTools config = (ServiceActionTools)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("ServiceActionTools 构型失败。");
			}
			String tmpClassName = UtilTools.getTrim( config.getClassname() );
			
			Object newActionClass = Class.forName(tmpClassName).newInstance();
			
			if(!( newActionClass instanceof org.zml.data.vo.tools.action.IFormActionTools )){
				throw new Exception("Form 使用的ActionTools 必须实现org.zml.data.vo.tools.action.IFormActionTools接口。");
			}
			
			result = ( org.zml.data.vo.tools.action.IActionTools )newActionClass;
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parserFormActionTools 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parserFormActionTools 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parserFormActionTools 抛出异常， 异常信息：" + localMessage);
				}
			}
			result = null;
		}
		return result;
	}
	

	@Override 
	public IConnectionAble parseConnection() throws DataServiceException{
		IConnectionAble result = null;
		try{
			logger.debug("ServiceActionToolsSQLParser开始执行parseConnection。");	
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ServiceActionTools config = (ServiceActionTools)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("ServiceActionTools 构型失败。");
			}
			
			if( config.getConnection() ==  null){
				throw new Exception("ServiceActionTools 没有配置Connection");
			}
			
			SQLParserAble connectionParser = SQLParserFactory.getQueryDefineInterpreter( config.getConnection() );
			if( connectionParser == null ){
				throw new Exception("Connection 创建SQLParserAble 错误。");
			}
			
			result = connectionParser.parseConnection();
		
			logger.debug("ServiceActionToolsSQLParser执行parseConnection完毕。");	
			
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parseConnection 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parseConnection 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parseConnection 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}