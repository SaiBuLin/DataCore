package org.zml.data.vo.command.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.command.bind.RequestTask;
import org.zml.data.vo.command.bind.RequestTaskGroup;
import org.zml.util.UtilTools;

public class RequestTaskGroupSQLCommand extends SQLCommand implements SQLCommandAble
{
	public RequestTaskGroupSQLCommand( RequestTaskGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestTaskGroup))
		{
			throw new Exception(" RequestTaskGroupSQLCommand only parse RequestTaskGroup");
		}
		result = true;
		return result;
	}
	
	@Override
	public void addRequestTask( RequestTask task ) throws Exception{
		try{
			logger.debug("��ʼִ��addRequestTask��");
			
			if( task == null ){
				throw new Exception("��ڲ���taskΪ�ա�");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			String code = UtilTools.getTrim( task.getCode() );
			
			if( UtilTools.isNull(code) ){
				throw new Exception("��ڲ���task��Ҫ��������code.");
			}
			
			RequestTaskGroup config = (RequestTaskGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����RequestTaskGroup����");
			}
			
			logger.debug("��ȡCommandConfiguration��requestTask, ��������Ӧ��SQLCommandAble��");
			if( config.getRequestTask() == null ){
				config.setRequestTask(new ArrayList<RequestTask>());
			}
			
			logger.debug("��requestTask���б���Ѱ�ң���������ͬcode ��requestTask���֡���");
			
			/* ��������ʱ��Ҫ�������� */
			Boolean IsExists = false;
			int mSize = config.getRequestTask().size();
			int maxIndex = -1;
			for( int ii = 0; ii < mSize; ii++ ){
				RequestTask taskelement = config.getRequestTask().get(ii);
				if( taskelement == null ){
					logger.error("config��requestTask�ĳ�ԱΪ�ա�");
					continue;
				}
				if( maxIndex < taskelement.getIndex()  ){
					maxIndex =  taskelement.getIndex();
				}
			}
			for( int ii = 0; ii < mSize; ii++ ){
				RequestTask taskelement = config.getRequestTask().get(ii);
				if( taskelement == null ){
					logger.error("config��requestTask�ĳ�ԱΪ�ա�");
					continue;
				}
				String taskcode = UtilTools.getTrim( taskelement.getCode() );
				if( code.equalsIgnoreCase(taskcode)){
					IsExists  = true;
					break;
				}
			}
			
			if( !IsExists ){			
				task.setIndex(maxIndex + 1);
				config.getRequestTask().add(task);
			}
			
			logger.debug("ִ��addRequestTask��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestTaskGroupSQLCommand::addRequestTask �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RequestTaskGroupSQLCommand::addRequestTask �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestTaskGroupSQLCommand::addRequestTask �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override
	public Map<Integer, RequestTask> getRequestTask() throws Exception{
		Map<Integer, RequestTask> result = new HashMap<Integer,RequestTask>();
		try{
			logger.debug("��ʼִ��getRequestTask��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			RequestTaskGroup config = (RequestTaskGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����RequestTaskGroup����");
			}
			
			if( config.getRequestTask() == null ){
				throw new Exception("RequestTaskGroup��requestTask����Ϊ�ա�");
			}
			
			
			int mSize = config.getRequestTask().size();
			
			if( mSize == 0 ){
				return result;
			}
			logger.debug(" ����index �������� ");
			Collections.sort(config.getRequestTask(), new SQLCommandComparor());
			
			int newindex = 1;
			
			for( int ii = 0; ii < mSize; ii++ ){
				RequestTask task =  config.getRequestTask().get(ii);
				if( task == null)continue;
				if( task.getIndex() < 1 ) continue;
				
				/* ����index */
				SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( task );
				if( taskAble == null )continue;
				Map<Integer, RequestTask> tasks = taskAble.getRequestTask();
				if( tasks == null)continue;
				
				for( int jj = 0; jj < tasks.size(); jj++ ){
					Integer tmpkey = (Integer)tasks.keySet().toArray()[jj];
					if( tmpkey == null )continue;
					RequestTask taskelement = tasks.get(tmpkey);
					
					if( taskelement == null )continue;
					taskelement.setIndex(newindex);
					
					result.put(newindex, taskelement);
					newindex++;
				}				
			}	
			
			logger.debug("ִ��getRequestTask��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestTaskGroupSQLCommand::getRequestTask �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RequestTaskGroupSQLCommand::getRequestTask �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestTaskGroupSQLCommand::getRequestTask �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return new HashMap<Integer,RequestTask>();
	}


	@Override
	public void removeRequestTaskBy(String code) throws Exception{
		try{
			logger.debug("��ʼִ��removeRequestTaskBy��");
			
			if( UtilTools.isNull(code) ){
				throw new Exception("��ڲ���codeΪ�ա�");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			String tmpCode = UtilTools.getTrim( code );
			
			RequestTaskGroup config = (RequestTaskGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����RequestTaskGroup����");
			}
			
			logger.debug("��ȡRequestTaskGroup��requestTask, ��������Ӧ��SQLCommandAble��");
			if( config.getRequestTask() == null ){
				logger.warn( "Config ������requestTask Ϊ�գ� " );
				throw new Exception("RequestTaskGroup��requestTaskΪ�ա�");
			}
			
			int mSize = config.getRequestTask().size();
			int indexfordel = -1;
			for( int ii = 0; ii < mSize; ii++ ){
				RequestTask task = config.getRequestTask().get(ii);
				
				if( task == null )continue;
				
				String taskCode = UtilTools.getTrim( task.getCode() );
				if(UtilTools.isNull(taskCode)){
					logger.warn("RequestTask ��Ҫ����code.");
					continue;
				}
				if( tmpCode.equalsIgnoreCase(taskCode)){
					indexfordel = ii;
					break;
				}
			}
			
			if( indexfordel >= 0 ){
				logger.debug("����ɾ��requestTask.");
				config.getRequestTask().remove(indexfordel);
			}else if( indexfordel < 0) {
				
				int jjSize = config.getRequestTask().size();
				for( int ii = 0; ii < jjSize; ii++ ){
					RequestTask task = config.getRequestTask().get(ii);
					
					if( task == null )continue;
					
					SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( task );
					if( taskAble == null )continue;
					
					taskAble.removeRequestTaskBy(tmpCode);
				}
			}
			
			logger.debug("ִ��removeRequestTaskBy��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestTaskGroupSQLCommand::removeRequestTaskBy �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RequestTaskGroupSQLCommand::removeRequestTaskBy �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestTaskGroupSQLCommand::removeRequestTaskBy �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

}