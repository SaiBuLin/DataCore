package org.zml.data.vo.command.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.RequestTask;
import org.zml.data.vo.command.bind.RequestTaskGroup;
import org.zml.data.vo.command.bind.ServiceTask;
import org.zml.util.UtilTools;

public class CommandConfigurationSQLCommand extends SQLCommand implements SQLCommandAble
{
	public CommandConfigurationSQLCommand( CommandConfiguration element)
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
		if ( !(this.getQueryDefineElement() instanceof CommandConfiguration))
		{
			throw new Exception(" CommandConfigurationSQLCommand only parse CommandConfiguration");
		}
		result = true;
		return result;
	}
	
	@Override
	public void addRequestTask(RequestTask task ) throws Exception{
		try{
			logger.debug("��ʼִ��addRequestTask��");
			
			if( task == null ){
				throw new Exception("��ڲ���taskΪ�ա�");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����CommandConfiguration����");
			}
			
			logger.debug("��ȡCommandConfiguration��requestTask, ��������Ӧ��SQLCommandAble��");
			if( config.getRequestTask() == null ){
				logger.warn( "Config ������requestTask Ϊ�գ� " );
				config.setRequestTask( new RequestTaskGroup() );
			}
			
			SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( config.getRequestTask() );
			if( taskAble == null ){
				throw new Exception("CommandConfiguration��requestTask����SQLCommandAble����");
			}
			
			logger.debug("��requestTask����task��");
			taskAble.addRequestTask(task);
			
			logger.debug("ִ��addRequestTask��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::addRequestTask �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::addRequestTask �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::addRequestTask �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override
	public void addRequestTask(CommandConfiguration configParam ) throws Exception{
		try{
			logger.debug("��ʼִ��addRequestTask��");
			
			if( configParam == null ){
				throw new Exception("��ڲ���configParamΪ�ա�");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����CommandConfiguration����");
			}
			
			logger.debug("��ȡCommandConfiguration��requestTask, ��������Ӧ��SQLCommandAble��");
			if( config.getRequestTask() == null ){
				logger.warn( "Config ������requestTask Ϊ�գ� " );
				config.setRequestTask( new RequestTaskGroup() );
			}
			
			SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( config.getRequestTask() );
			if( taskAble == null ){
				throw new Exception("CommandConfiguration��requestTask����SQLCommandAble����");
			}
			
			logger.debug("��requestTask����task��");
			taskAble.addRequestTask( configParam.getRequestTask());
			
			logger.debug("ִ��addRequestTask��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::addRequestTask �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::addRequestTask �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::addRequestTask �׳��쳣�� �쳣��Ϣ��" + localMessage);
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
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����CommandConfiguration����");
			}
			
			logger.debug("��ȡCommandConfiguration��requestTask, ��������Ӧ��SQLCommandAble��");
			if( config.getRequestTask() == null ){
				throw new Exception("CommandConfiguration��requestTaskû�����á�");
			}
			
			SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( config.getRequestTask() );
			if( taskAble == null ){
				throw new Exception("CommandConfiguration��requestTask����SQLCommandAble����");
			}
			
			logger.debug("���requestTask ��Ӧ���Ե�task�б�");
			Map<Integer, RequestTask> taskmaps = taskAble.getRequestTask();
			if( taskmaps == null  ){
				throw new Exception("requestTask���Ե�ִ��getRequestTask��������Ϊ�ա�");
			}
			
			if( taskmaps.size() == 0 ){
				logger.warn("����requestTask��SQLCommandAble ��ȡ��requestTask�б�ļ�¼��Ϊ0.");
			}
			
			result.putAll(taskmaps);
			
			logger.debug("ִ��getRequestTask��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::getRequestTask �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::getRequestTask �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::getRequestTask �׳��쳣�� �쳣��Ϣ��" + localMessage);
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
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����CommandConfiguration����");
			}
			
			logger.debug("��ȡCommandConfiguration��requestTask, ��������Ӧ��SQLCommandAble��");
			if( config.getRequestTask() == null ){
				logger.warn( "Config ������requestTask Ϊ�գ� " );
				config.setRequestTask( new RequestTaskGroup() );
			}
			
			SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( config.getRequestTask() );
			if( taskAble == null ){
				throw new Exception("CommandConfiguration��requestTask����SQLCommandAble����");
			}
			
			logger.debug("��requestTaskɾ��task��");
			taskAble.removeRequestTaskBy(code);
			
			logger.debug("ִ��removeRequestTaskBy��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::removeRequestTaskBy �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::removeRequestTaskBy �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::removeRequestTaskBy �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	@Override
	public RequestTask indexRequestTask(int index) throws Exception{
		RequestTask result = null;
		try{
			logger.debug("��ʼִ��indexRequestTask��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			Map<Integer, RequestTask> requestTasks = getRequestTask();
			
			if( requestTasks == null ){
				logger.warn("��ǰCommandConfiguration û�������κ�RequestTask.");
				return result;
			}
			
			if( requestTasks.size() == 0 ){
				logger.warn("��ǰCommandConfiguration û�������κ�RequestTask.");
				return result;
			}
			
			Integer key = new Integer(index);
			
			if( requestTasks.containsKey( key ) ){
				result = requestTasks.get( key );
			}
			
			logger.debug("ִ��indexRequestTask��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::indexRequestTask �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::indexRequestTask �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::indexRequestTask �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}

	/**
	 * ����code ���TaskRequest
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public RequestTask getRequestTaskByCode(String code) throws Exception{
		RequestTask result = null;
		try{
			logger.debug("��ʼִ��getRequestTaskByCode��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			if(UtilTools.isNull( code )){
				logger.error("��ڲ���code Ϊ�գ��޷������ָ����Request Task.");
				return result;
			}
			logger.debug("����getRequestTask���requestTask Map�б�");
			Map<Integer, RequestTask> requestTasks = getRequestTask();
			
			if( requestTasks == null ){
				logger.warn("��ǰCommandConfiguration û�������κ�RequestTask.");
				return result;
			}
			
			if( requestTasks.size() == 0 ){
				logger.warn("��ǰCommandConfiguration û�������κ�RequestTask.");
				return result;
			}
			logger.debug("����requestTask Map �б��ж��Ƿ����code ��TaskRequest��");
			String tmpCode = UtilTools.getTrim( code );
			
			int mSize = requestTasks.size();
			for( int ii = 0; ii < mSize; ii++ ){
				Object key =  requestTasks.keySet().toArray()[ii];
				if( key == null )continue;
				RequestTask requestTask = requestTasks.get(key);
				String inputcode = UtilTools.getTrim( requestTask.getCode() );
				
				if( inputcode.equalsIgnoreCase(tmpCode)){
					logger.debug("���б��ҵ���ӦCode��");
					result = requestTask;
					break;
				}
			}
			
			logger.debug("ִ��getRequestTaskByCode��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskByCode �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::getRequestTaskByCode �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskByCode �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public String getRequestTaskContent(int index)throws Exception{
		String result = "";
		try{
			logger.debug("��ʼִ��getRequestTaskContent��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			RequestTask requestTask = this.indexRequestTask(index);
			if( requestTask == null ){
				logger.error("index:" + index + "��Ӧ��requestTask û���ҵ���");
				return result;
			}
			
			SQLCommandAble requestTaskAble = SQLCommandFactory.getQueryDefineInterpreter(requestTask);
			if(  requestTaskAble != null ){
				result = requestTaskAble.getRequestTaskContent();
			}
			
			logger.debug("ִ��getRequestTaskContent��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskContent �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::getRequestTaskContent �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskContent �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return "";
	}
	
	@Override
	public String getRequestTaskContent(String code)throws Exception{
		String result = "";
		try{
			logger.debug("��ʼִ��getRequestTaskContent��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			if(UtilTools.isNull( code )){
				logger.error("��ڲ���code Ϊ�գ��޷������ָ����Request Task.");
				return result;
			}
			
			RequestTask requestTask = this.getRequestTaskByCode(code);
			if( requestTask == null ){
				logger.error("code:" + code + "��Ӧ��requestTask û���ҵ���");
				return result;
			}
			
			SQLCommandAble requestTaskAble = SQLCommandFactory.getQueryDefineInterpreter(requestTask);
			if(  requestTaskAble != null ){
				result = requestTaskAble.getRequestTaskContent();
			}
			
			logger.debug("ִ��getRequestTaskContent��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskContent �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::getRequestTaskContent �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskContent �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return "";
	}
	
	@Override
	public String getRequestTaskContent() throws Exception{
		return this.getRequestTaskContent(0);
	}
	
	
	@Override
	public void insertRequestTask(String code, String commandString )throws Exception{
		try{
			logger.debug("��ʼִ��insertRequestTask��");
			
			if( UtilTools.isNull(commandString) ){
				throw new Exception("��ڲ���commandStringΪ�ա�");
			}
			
			if( UtilTools.isNull(code) ){
				throw new Exception("��ڲ���codeΪ�ա�");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElementǿ��ת����CommandConfiguration����");
			}
			
			logger.debug("��ȡCommandConfiguration��requestTask, ��������Ӧ��SQLCommandAble��");
			if( config.getRequestTask() == null ){
				logger.warn( "Config ������requestTask Ϊ�գ� " );
				config.setRequestTask( new RequestTaskGroup() );
			}
			
			ServiceTask requestTask = new ServiceTask();
			requestTask.setCode(UtilTools.getTrim(code));
			requestTask.setIndex(0);
			
			this.addRequestTask( requestTask );
			
			logger.debug("ִ��insertRequestTask��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::insertRequestTask �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::insertRequestTask �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::insertRequestTask �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}