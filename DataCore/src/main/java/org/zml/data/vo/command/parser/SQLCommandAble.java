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
	 * ���������
	 * @param taskcommd
	 * @param params
	 * @throws Exception
	 */
	public void addRequestTask(RequestTask task ) throws Exception;
	
	/**
	 * ��������
	 * @param config
	 * @throws Exception
	 */
	public void addRequestTask(CommandConfiguration config ) throws Exception;
	
	public void insertRequestTask(String code, String commandString )throws Exception;
	
	/**
	 * ��������б�
	 * @return
	 * @throws Exception
	 */
	public Map<Integer, RequestTask> getRequestTask() throws Exception;
	
	/**
	 * ɾ������
	 * @param code
	 * @throws Exception
	 */
	public void removeRequestTaskBy(String code) throws Exception;
	
	/**
	 * ����code ���TaskRequest
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public RequestTask getRequestTaskByCode(String code) throws Exception;
	
	/**
	 * ���ָ��index ��ӦRequestTask
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public RequestTask indexRequestTask(int index) throws Exception;
	
	public String getRequestTaskContent(int index)throws Exception;
	
	public String getRequestTaskContent(String code)throws Exception;
	
	/**
	 * ���RequestTask 
	 */
	public String getRequestTaskContent() throws Exception;
	
	/**
	 * ���Parameter
	 * @param parameter
	 * @throws Exception
	 */
	public void addParameter( RequestParameter parameter ) throws Exception;
	
	/**
	 * ���parameter �б�
	 * @return
	 * @throws Exception
	 */
	public List<RequestParameter> getParameters() throws Exception;
	
	
}