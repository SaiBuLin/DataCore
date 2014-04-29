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
			logger.debug("开始执行addRequestTask。");
			
			if( task == null ){
				throw new Exception("入口参数task为空。");
			}
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			String code = UtilTools.getTrim( task.getCode() );
			
			if( UtilTools.isNull(code) ){
				throw new Exception("入口参数task需要配置属性code.");
			}
			
			RequestTaskGroup config = (RequestTaskGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成RequestTaskGroup错误。");
			}
			
			logger.debug("读取CommandConfiguration的requestTask, 并创建对应的SQLCommandAble。");
			if( config.getRequestTask() == null ){
				config.setRequestTask(new ArrayList<RequestTask>());
			}
			
			logger.debug("在requestTask的列表中寻找，避免有相同code 的requestTask出现。。");
			
			/* 添加任务的时候要进行排序 */
			Boolean IsExists = false;
			int mSize = config.getRequestTask().size();
			int maxIndex = -1;
			for( int ii = 0; ii < mSize; ii++ ){
				RequestTask taskelement = config.getRequestTask().get(ii);
				if( taskelement == null ){
					logger.error("config中requestTask的成员为空。");
					continue;
				}
				if( maxIndex < taskelement.getIndex()  ){
					maxIndex =  taskelement.getIndex();
				}
			}
			for( int ii = 0; ii < mSize; ii++ ){
				RequestTask taskelement = config.getRequestTask().get(ii);
				if( taskelement == null ){
					logger.error("config中requestTask的成员为空。");
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
			
			logger.debug("执行addRequestTask完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestTaskGroupSQLCommand::addRequestTask 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RequestTaskGroupSQLCommand::addRequestTask 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestTaskGroupSQLCommand::addRequestTask 抛出异常， 异常信息：" + localMessage);
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
			
			RequestTaskGroup config = (RequestTaskGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成RequestTaskGroup错误。");
			}
			
			if( config.getRequestTask() == null ){
				throw new Exception("RequestTaskGroup的requestTask属性为空。");
			}
			
			
			int mSize = config.getRequestTask().size();
			
			if( mSize == 0 ){
				return result;
			}
			logger.debug(" 根据index 进行排序 ");
			Collections.sort(config.getRequestTask(), new SQLCommandComparor());
			
			int newindex = 1;
			
			for( int ii = 0; ii < mSize; ii++ ){
				RequestTask task =  config.getRequestTask().get(ii);
				if( task == null)continue;
				if( task.getIndex() < 1 ) continue;
				
				/* 调整index */
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
			
			logger.debug("执行getRequestTask完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestTaskGroupSQLCommand::getRequestTask 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RequestTaskGroupSQLCommand::getRequestTask 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestTaskGroupSQLCommand::getRequestTask 抛出异常， 异常信息：" + localMessage);
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
			
			String tmpCode = UtilTools.getTrim( code );
			
			RequestTaskGroup config = (RequestTaskGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("queryDefineElement强制转换成RequestTaskGroup错误。");
			}
			
			logger.debug("读取RequestTaskGroup的requestTask, 并创建对应的SQLCommandAble。");
			if( config.getRequestTask() == null ){
				logger.warn( "Config 的属性requestTask 为空， " );
				throw new Exception("RequestTaskGroup的requestTask为空。");
			}
			
			int mSize = config.getRequestTask().size();
			int indexfordel = -1;
			for( int ii = 0; ii < mSize; ii++ ){
				RequestTask task = config.getRequestTask().get(ii);
				
				if( task == null )continue;
				
				String taskCode = UtilTools.getTrim( task.getCode() );
				if(UtilTools.isNull(taskCode)){
					logger.warn("RequestTask 需要配置code.");
					continue;
				}
				if( tmpCode.equalsIgnoreCase(taskCode)){
					indexfordel = ii;
					break;
				}
			}
			
			if( indexfordel >= 0 ){
				logger.debug("正常删除requestTask.");
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
			
			logger.debug("执行removeRequestTaskBy完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestTaskGroupSQLCommand::removeRequestTaskBy 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RequestTaskGroupSQLCommand::removeRequestTaskBy 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestTaskGroupSQLCommand::removeRequestTaskBy 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

}