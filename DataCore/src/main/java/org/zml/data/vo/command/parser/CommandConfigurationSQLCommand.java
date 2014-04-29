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
			logger.debug("开始执行addRequestTask。");
			
			if( task == null ){
				throw new Exception("入口参数task为空。");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成CommandConfiguration错误。");
			}
			
			logger.debug("读取CommandConfiguration的requestTask, 并创建对应的SQLCommandAble。");
			if( config.getRequestTask() == null ){
				logger.warn( "Config 的属性requestTask 为空， " );
				config.setRequestTask( new RequestTaskGroup() );
			}
			
			SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( config.getRequestTask() );
			if( taskAble == null ){
				throw new Exception("CommandConfiguration的requestTask创建SQLCommandAble错误。");
			}
			
			logger.debug("在requestTask增加task。");
			taskAble.addRequestTask(task);
			
			logger.debug("执行addRequestTask完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::addRequestTask 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::addRequestTask 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::addRequestTask 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override
	public void addRequestTask(CommandConfiguration configParam ) throws Exception{
		try{
			logger.debug("开始执行addRequestTask。");
			
			if( configParam == null ){
				throw new Exception("入口参数configParam为空。");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成CommandConfiguration错误。");
			}
			
			logger.debug("读取CommandConfiguration的requestTask, 并创建对应的SQLCommandAble。");
			if( config.getRequestTask() == null ){
				logger.warn( "Config 的属性requestTask 为空， " );
				config.setRequestTask( new RequestTaskGroup() );
			}
			
			SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( config.getRequestTask() );
			if( taskAble == null ){
				throw new Exception("CommandConfiguration的requestTask创建SQLCommandAble错误。");
			}
			
			logger.debug("在requestTask增加task。");
			taskAble.addRequestTask( configParam.getRequestTask());
			
			logger.debug("执行addRequestTask完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::addRequestTask 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::addRequestTask 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::addRequestTask 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override
	public Map<Integer, RequestTask> getRequestTask() throws Exception{
		Map<Integer, RequestTask> result = new HashMap<Integer,RequestTask>();
		try{
			logger.debug("开始执行getRequestTask。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成CommandConfiguration错误。");
			}
			
			logger.debug("读取CommandConfiguration的requestTask, 并创建对应的SQLCommandAble。");
			if( config.getRequestTask() == null ){
				throw new Exception("CommandConfiguration的requestTask没有配置。");
			}
			
			SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( config.getRequestTask() );
			if( taskAble == null ){
				throw new Exception("CommandConfiguration的requestTask创建SQLCommandAble错误。");
			}
			
			logger.debug("获得requestTask 对应属性的task列表。");
			Map<Integer, RequestTask> taskmaps = taskAble.getRequestTask();
			if( taskmaps == null  ){
				throw new Exception("requestTask属性的执行getRequestTask方法返回为空。");
			}
			
			if( taskmaps.size() == 0 ){
				logger.warn("属性requestTask的SQLCommandAble 读取的requestTask列表的记录数为0.");
			}
			
			result.putAll(taskmaps);
			
			logger.debug("执行getRequestTask完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::getRequestTask 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::getRequestTask 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::getRequestTask 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return new HashMap<Integer,RequestTask>();
	}
	
	@Override
	public void removeRequestTaskBy(String code) throws Exception{
		try{
			logger.debug("开始执行removeRequestTaskBy。");
			
			if( UtilTools.isNull(code) ){
				throw new Exception("入口参数code为空。");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成CommandConfiguration错误。");
			}
			
			logger.debug("读取CommandConfiguration的requestTask, 并创建对应的SQLCommandAble。");
			if( config.getRequestTask() == null ){
				logger.warn( "Config 的属性requestTask 为空， " );
				config.setRequestTask( new RequestTaskGroup() );
			}
			
			SQLCommandAble taskAble = SQLCommandFactory.getQueryDefineInterpreter( config.getRequestTask() );
			if( taskAble == null ){
				throw new Exception("CommandConfiguration的requestTask创建SQLCommandAble错误。");
			}
			
			logger.debug("在requestTask删除task。");
			taskAble.removeRequestTaskBy(code);
			
			logger.debug("执行removeRequestTaskBy完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::removeRequestTaskBy 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::removeRequestTaskBy 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::removeRequestTaskBy 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

	@Override
	public RequestTask indexRequestTask(int index) throws Exception{
		RequestTask result = null;
		try{
			logger.debug("开始执行indexRequestTask。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			Map<Integer, RequestTask> requestTasks = getRequestTask();
			
			if( requestTasks == null ){
				logger.warn("当前CommandConfiguration 没有配置任何RequestTask.");
				return result;
			}
			
			if( requestTasks.size() == 0 ){
				logger.warn("当前CommandConfiguration 没有配置任何RequestTask.");
				return result;
			}
			
			Integer key = new Integer(index);
			
			if( requestTasks.containsKey( key ) ){
				result = requestTasks.get( key );
			}
			
			logger.debug("执行indexRequestTask完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::indexRequestTask 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::indexRequestTask 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::indexRequestTask 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}

	/**
	 * 根据code 获得TaskRequest
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public RequestTask getRequestTaskByCode(String code) throws Exception{
		RequestTask result = null;
		try{
			logger.debug("开始执行getRequestTaskByCode。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			if(UtilTools.isNull( code )){
				logger.error("入口参数code 为空，无法获得所指出的Request Task.");
				return result;
			}
			logger.debug("调用getRequestTask获得requestTask Map列表。");
			Map<Integer, RequestTask> requestTasks = getRequestTask();
			
			if( requestTasks == null ){
				logger.warn("当前CommandConfiguration 没有配置任何RequestTask.");
				return result;
			}
			
			if( requestTasks.size() == 0 ){
				logger.warn("当前CommandConfiguration 没有配置任何RequestTask.");
				return result;
			}
			logger.debug("遍历requestTask Map 列表，判断是否存在code 的TaskRequest。");
			String tmpCode = UtilTools.getTrim( code );
			
			int mSize = requestTasks.size();
			for( int ii = 0; ii < mSize; ii++ ){
				Object key =  requestTasks.keySet().toArray()[ii];
				if( key == null )continue;
				RequestTask requestTask = requestTasks.get(key);
				String inputcode = UtilTools.getTrim( requestTask.getCode() );
				
				if( inputcode.equalsIgnoreCase(tmpCode)){
					logger.debug("在列表找到对应Code。");
					result = requestTask;
					break;
				}
			}
			
			logger.debug("执行getRequestTaskByCode完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskByCode 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::getRequestTaskByCode 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskByCode 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public String getRequestTaskContent(int index)throws Exception{
		String result = "";
		try{
			logger.debug("开始执行getRequestTaskContent。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			RequestTask requestTask = this.indexRequestTask(index);
			if( requestTask == null ){
				logger.error("index:" + index + "对应的requestTask 没有找到。");
				return result;
			}
			
			SQLCommandAble requestTaskAble = SQLCommandFactory.getQueryDefineInterpreter(requestTask);
			if(  requestTaskAble != null ){
				result = requestTaskAble.getRequestTaskContent();
			}
			
			logger.debug("执行getRequestTaskContent完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskContent 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::getRequestTaskContent 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskContent 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return "";
	}
	
	@Override
	public String getRequestTaskContent(String code)throws Exception{
		String result = "";
		try{
			logger.debug("开始执行getRequestTaskContent。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			if(UtilTools.isNull( code )){
				logger.error("入口参数code 为空，无法获得所指出的Request Task.");
				return result;
			}
			
			RequestTask requestTask = this.getRequestTaskByCode(code);
			if( requestTask == null ){
				logger.error("code:" + code + "对应的requestTask 没有找到。");
				return result;
			}
			
			SQLCommandAble requestTaskAble = SQLCommandFactory.getQueryDefineInterpreter(requestTask);
			if(  requestTaskAble != null ){
				result = requestTaskAble.getRequestTaskContent();
			}
			
			logger.debug("执行getRequestTaskContent完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskContent 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::getRequestTaskContent 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::getRequestTaskContent 抛出异常， 异常信息：" + localMessage);
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
			logger.debug("开始执行insertRequestTask。");
			
			if( UtilTools.isNull(commandString) ){
				throw new Exception("入口参数commandString为空。");
			}
			
			if( UtilTools.isNull(code) ){
				throw new Exception("入口参数code为空。");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			CommandConfiguration config = (CommandConfiguration)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成CommandConfiguration错误。");
			}
			
			logger.debug("读取CommandConfiguration的requestTask, 并创建对应的SQLCommandAble。");
			if( config.getRequestTask() == null ){
				logger.warn( "Config 的属性requestTask 为空， " );
				config.setRequestTask( new RequestTaskGroup() );
			}
			
			ServiceTask requestTask = new ServiceTask();
			requestTask.setCode(UtilTools.getTrim(code));
			requestTask.setIndex(0);
			
			this.addRequestTask( requestTask );
			
			logger.debug("执行insertRequestTask完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("CommandConfigurationSQLCommand::insertRequestTask 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("CommandConfigurationSQLCommand::insertRequestTask 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("CommandConfigurationSQLCommand::insertRequestTask 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
}