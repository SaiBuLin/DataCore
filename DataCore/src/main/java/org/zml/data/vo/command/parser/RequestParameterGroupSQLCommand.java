package org.zml.data.vo.command.parser;

import java.util.ArrayList;
import java.util.List;

import org.zml.data.vo.command.bind.RequestParameter;
import org.zml.data.vo.command.bind.RequestParameterGroup;
import org.zml.util.UtilTools;

public class RequestParameterGroupSQLCommand extends SQLCommand implements SQLCommandAble
{
	public RequestParameterGroupSQLCommand( RequestParameterGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestParameterGroup))
		{
			throw new Exception(" RequestParameterGroupSQLCommand only parse RequestParameterGroup");
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
			
			if( parameter == null ){
				throw new Exception("入口参数parameter 为空。");
			}
			
			RequestParameterGroup config = (RequestParameterGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成RequestParameterGroup错误。");
			}
			
			if( config.getRequestParameter() == null ){
				config.setRequestParameter( new ArrayList<RequestParameter>() );
			}
			
			SQLCommandAble inputParamAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
			
			if( inputParamAble == null ){
				throw new Exception("入口参数parameter生成SQLCommandAble错误。");
			}
			
			List<RequestParameter> inputParams = inputParamAble.getParameters();
			
			int mSize = config.getRequestParameter().size();
			
			for( int ii = 0; ii < inputParams.size(); ii++  ){
				RequestParameter iparam = inputParams.get(ii);
				iparam.setIndex( mSize + ii + 1);
				
				config.getRequestParameter().add( iparam );
			}
			
			logger.debug("执行addParameter完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestParameterGroupSQLCommand::addParameter 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RequestParameterGroupSQLCommand::addParameter 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestParameterGroupSQLCommand::addParameter 抛出异常， 异常信息：" + localMessage);
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
			
			
			RequestParameterGroup config = (RequestParameterGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成RequestParameterGroup错误。");
			}
			
			if( config.getRequestParameter() == null ){
				logger.warn("RequestParameterGroup 没有requestParameter 成员。");
				return result;
			}
			
			for( int ii = 0; ii < config.getRequestParameter().size(); ii++ ){
				RequestParameter parameter = config.getRequestParameter().get(ii);
				SQLCommandAble inputParamAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
				
				if( inputParamAble == null ) continue;
				List<RequestParameter> inputParams = inputParamAble.getParameters();
				
				if( inputParams != null ){
					result.addAll( inputParams );
				}				
			}
			
			logger.debug("执行getParameters完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestParameterGroupSQLCommand::getParameters 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RequestParameterGroupSQLCommand::getParameters 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestParameterGroupSQLCommand::getParameters 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		
		return new ArrayList<RequestParameter>();
	}
}