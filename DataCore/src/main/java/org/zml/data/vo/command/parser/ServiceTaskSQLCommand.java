package org.zml.data.vo.command.parser;

import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.command.bind.RequestTask;
import org.zml.data.vo.command.bind.ServiceTask;
import org.zml.util.UtilTools;

/**
 * 
 * @author zlmwork
 *
 */
public class ServiceTaskSQLCommand extends SQLCommand implements SQLCommandAble
{
	public ServiceTaskSQLCommand( ServiceTask element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceTask))
		{
			throw new Exception(" ServiceTaskSQLCommand only parse ServiceTask");
		}
		result = true;
		return result;
	}
	
	@Override
	public Map<Integer, RequestTask> getRequestTask() throws Exception{
		Map<Integer, RequestTask> result = new HashMap<Integer,RequestTask>();
		try{
			logger.debug("开始执行getRequestTask。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			ServiceTask config = (ServiceTask)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成ServiceTask错误。");
			}
			
			Integer key = config.getIndex();
			if( key < 0 ){
				throw new Exception("serviceTask没有配置index。");
			}
			
			result.put( key, config );
			
			logger.debug("执行getRequestTask完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceTaskSQLCommand::getRequestTask 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceTaskSQLCommand::getRequestTask 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceTaskSQLCommand::getRequestTask 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return new HashMap<Integer,RequestTask>();
	}
	
	@Override
	public String getRequestTaskContent() throws Exception{
		String result = "";
		try{
			logger.debug("开始执行getRequestTaskContent。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			ServiceTask config = (ServiceTask)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成ServiceTask错误。");
			}
			
			result = UtilTools.getTrim( config.getCommandContent() );
			
			
			logger.debug("执行getRequestTaskContent完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceTaskSQLCommand::getRequestTaskContent 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceTaskSQLCommand::getRequestTaskContent 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceTaskSQLCommand::getRequestTaskContent 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return "";
	}
}