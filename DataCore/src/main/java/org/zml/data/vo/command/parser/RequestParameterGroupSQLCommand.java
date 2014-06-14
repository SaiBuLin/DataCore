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
			logger.debug("��ʼִ��addParameter��");
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			if( parameter == null ){
				throw new Exception("��ڲ���parameter Ϊ�ա�");
			}
			
			RequestParameterGroup config = (RequestParameterGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����RequestParameterGroup����");
			}
			
			if( config.getRequestParameter() == null ){
				config.setRequestParameter( new ArrayList<RequestParameter>() );
			}
			
			SQLCommandAble inputParamAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
			
			if( inputParamAble == null ){
				throw new Exception("��ڲ���parameter����SQLCommandAble����");
			}
			
			List<RequestParameter> inputParams = inputParamAble.getParameters();
			
			int mSize = config.getRequestParameter().size();
			
			for( int ii = 0; ii < inputParams.size(); ii++  ){
				RequestParameter iparam = inputParams.get(ii);
				iparam.setIndex( mSize + ii + 1);
				
				config.getRequestParameter().add( iparam );
			}
			
			logger.debug("ִ��addParameter��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestParameterGroupSQLCommand::addParameter �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RequestParameterGroupSQLCommand::addParameter �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestParameterGroupSQLCommand::addParameter �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		
	}
	
	public List<RequestParameter> getParameters() throws Exception{
		List<RequestParameter> result = new ArrayList<RequestParameter>();
		
		try{
			logger.debug("��ʼִ��getParameters��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			
			RequestParameterGroup config = (RequestParameterGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����RequestParameterGroup����");
			}
			
			if( config.getRequestParameter() == null ){
				logger.warn("RequestParameterGroup û��requestParameter ��Ա��");
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
			
			logger.debug("ִ��getParameters��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestParameterGroupSQLCommand::getParameters �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RequestParameterGroupSQLCommand::getParameters �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestParameterGroupSQLCommand::getParameters �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		
		return new ArrayList<RequestParameter>();
	}
}