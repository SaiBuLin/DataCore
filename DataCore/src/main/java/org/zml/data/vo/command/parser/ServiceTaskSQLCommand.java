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
			logger.debug("��ʼִ��getRequestTask��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			ServiceTask config = (ServiceTask)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����ServiceTask����");
			}
			
			Integer key = config.getIndex();
			if( key < 0 ){
				throw new Exception("serviceTaskû������index��");
			}
			
			result.put( key, config );
			
			logger.debug("ִ��getRequestTask��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceTaskSQLCommand::getRequestTask �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceTaskSQLCommand::getRequestTask �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceTaskSQLCommand::getRequestTask �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return new HashMap<Integer,RequestTask>();
	}
	
	@Override
	public String getRequestTaskContent() throws Exception{
		String result = "";
		try{
			logger.debug("��ʼִ��getRequestTaskContent��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			ServiceTask config = (ServiceTask)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����ServiceTask����");
			}
			
			result = UtilTools.getTrim( config.getCommandContent() );
			
			
			logger.debug("ִ��getRequestTaskContent��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceTaskSQLCommand::getRequestTaskContent �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceTaskSQLCommand::getRequestTaskContent �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceTaskSQLCommand::getRequestTaskContent �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return "";
	}
}