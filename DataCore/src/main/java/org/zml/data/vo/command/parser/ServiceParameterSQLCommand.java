package org.zml.data.vo.command.parser;
import java.util.ArrayList;
import java.util.List;

import org.zml.data.vo.command.bind.RequestParameter;
import org.zml.data.vo.command.bind.ServiceParameter;
import org.zml.util.UtilTools;

public class ServiceParameterSQLCommand extends SQLCommand implements SQLCommandAble
{
	public ServiceParameterSQLCommand( ServiceParameter element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceParameter))
		{
			throw new Exception(" ServiceParameterSQLCommand only parse ServiceParameter");
		}
		result = true;
		return result;
	}
	
	@Override
	public void addParameter( RequestParameter parameter ) throws Exception{
		
		try{
			logger.debug("开始执行addParameter。");
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			logger.debug("执行addParameter完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceParameterSQLCommand::addParameter 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceParameterSQLCommand::addParameter 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceParameterSQLCommand::addParameter 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		
	}
	
	public List<RequestParameter> getParameters() throws Exception{
		List<RequestParameter> result = new ArrayList<RequestParameter>();
		
		try{
			logger.debug("开始执行getParameters。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			
			ServiceParameter config = (ServiceParameter)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成RequestParameterGroup错误。");
			}
			
			result.add( config );		
			
			logger.debug("执行getParameters完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceParameterSQLCommand::getParameters 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceParameterSQLCommand::getParameters 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceParameterSQLCommand::getParameters 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		
		return new ArrayList<RequestParameter>();
	}
}