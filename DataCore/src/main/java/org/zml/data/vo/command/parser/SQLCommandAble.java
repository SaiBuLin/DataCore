package org.zml.data.vo.command.parser;


import java.util.List;
import java.util.Map;

import org.zml.data.vo.command.bind.RequestParameter;
import org.zml.data.vo.command.bind.RequestTask;
import org.zml.data.vo.command.bind.CommandConfiguration;

public interface SQLCommandAble
{
	public boolean checkQueryElementComfort() throws Exception;

	/**
	 * 将命令加入
	 * @param taskcommd
	 * @param params
	 * @throws Exception
	 */
	public void addRequestTask(RequestTask task ) throws Exception;
	
	/**
	 * 加入命令
	 * @param config
	 * @throws Exception
	 */
	public void addRequestTask(CommandConfiguration config ) throws Exception;
	
	public void insertRequestTask(String code, String commandString )throws Exception;
	
	/**
	 * 获得命令列表
	 * @return
	 * @throws Exception
	 */
	public Map<Integer, RequestTask> getRequestTask() throws Exception;
	
	/**
	 * 删除命令
	 * @param code
	 * @throws Exception
	 */
	public void removeRequestTaskBy(String code) throws Exception;
	
	/**
	 * 根据code 获得TaskRequest
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public RequestTask getRequestTaskByCode(String code) throws Exception;
	
	/**
	 * 获得指定index 对应RequestTask
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public RequestTask indexRequestTask(int index) throws Exception;
	
	public String getRequestTaskContent(int index)throws Exception;
	
	public String getRequestTaskContent(String code)throws Exception;
	
	/**
	 * 获得RequestTask 
	 */
	public String getRequestTaskContent() throws Exception;
	
	/**
	 * 添加Parameter
	 * @param parameter
	 * @throws Exception
	 */
	public void addParameter( RequestParameter parameter ) throws Exception;
	
	/**
	 * 获得parameter 列表
	 * @return
	 * @throws Exception
	 */
	public List<RequestParameter> getParameters() throws Exception;
	
	
}