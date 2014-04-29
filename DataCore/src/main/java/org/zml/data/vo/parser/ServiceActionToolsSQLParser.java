package org.zml.data.vo.parser;
import java.util.HashMap;

import org.zml.data.vo.bind.ServiceActionTools;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.ServiceTask;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
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
	public CommandForm parserCommand(
			int index,
			VOForm form, 
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws DataServiceException{
		
		CommandForm result = null;
		try{
			
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ServiceActionTools config = (ServiceActionTools)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("ServiceActionTools 构型失败。");
			}
			
			if( form == null ){
				throw new Exception("入口参数form 为空。");
			}
			
			if( dataset == null ){
				throw new Exception("入口参数dataset 为空。");
			}
			
			if( config.getClassname() == null ){
				throw new Exception(" Action Tools 对应的className 没有指定。 ");
			}
			
			String tmpClassName = UtilTools.getTrim( config.getClassname() );
			
			Object newActionClass = Class.forName(tmpClassName).newInstance();
			
			if(!( newActionClass instanceof org.zml.data.vo.tools.action.IFormActionTools )){
				throw new Exception("Form 使用的ActionTools 必须实现org.zml.data.vo.tools.action.IFormActionTools接口。");
			}
			
			org.zml.data.vo.tools.action.IFormActionTools iActionTools = ( org.zml.data.vo.tools.action.IFormActionTools )newActionClass;
			String commandString = "";
			if( index == DATA_MODE_FOR_SELECT ){
				commandString = iActionTools.getFromQueryString( form, selectForm, whereForm, orderForm, groupbyForm, dataset );
			}
			else if( index == DATA_MODE_FOR_UPDATE ){
				commandString = iActionTools.getFromUpdateString( form, selectForm, whereForm, orderForm, groupbyForm, dataset );
			}
			else if( index == DATA_MODE_FOR_INSERT ){
				commandString = iActionTools.getFromInsertString( form, selectForm, whereForm, orderForm, groupbyForm, dataset );
			}
			else if( index == DATA_MODE_FOR_DELETE ){
				commandString = iActionTools.getFromDeleteString( form, selectForm, whereForm, orderForm, groupbyForm, dataset );
			}
			
			if(UtilTools.isNull(commandString)){
				throw new Exception("命令字为空");
			}
			
			CommandConfiguration commandconfig = new CommandConfiguration();
			ServiceTask taskrequest = new ServiceTask();
			taskrequest.setCommandContent(commandString);
			taskrequest.setIndex(0);
			taskrequest.setCode("CODE_INPUT_0");
			
			SQLCommandAble commandAble = SQLCommandFactory.getQueryDefineInterpreter(commandconfig);
			if( commandAble == null ){
				throw new Exception("Command 生成错误。");
			}
			commandAble.addRequestTask(taskrequest);
			
			
			result = new CommandForm();
			result.setCommand( commandconfig );
			result.setAlias( "" );
			result.setProperties(new HashMap<String,Object>());
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
	

	@Override
	public CommandForm parserCommand(
			int index,
			VOForm form, 
			CommandForm relationForm) throws DataServiceException{
		CommandForm result = null;
		try{
			
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
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