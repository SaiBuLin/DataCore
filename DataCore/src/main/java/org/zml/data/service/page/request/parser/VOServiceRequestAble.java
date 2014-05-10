package org.zml.data.service.page.request.parser;

import java.util.List;

import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.RequestTask;

/**
 * 
 * @author zlmwork
 * @see v2013.12 
 * 
 * 提取请求的配置
 */
public interface VOServiceRequestAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	
	/**
	 * 便利请求，获得Select 部分Field Names 用来和
	 * VO 配置对比
	 * @return
	 * @throws Exception
	 */
	public List<String> listSelectFieldNames() throws Exception;
	
	/**
	 * 便利Request 请求中条件字段列表
	 * @return
	 * @throws Exception
	 */
	public List<String> listWhereFieldNames() throws Exception;
	
	/**
	 * 便利Order by 请求
	 * @return
	 * @throws Exception
	 */
	public List<String> listOrderByFieldNames() throws Exception;
	
	/**
	 * 获得Group by 请求
	 * @return
	 * @throws Exception
	 */
	public List<String> listGroupByFieldNames() throws Exception;
	
	/**
	 * 根据requestTask 的信息和ConditionSyntax 生成where 条件
	 * 并且返回需要的command parameter 列表。
	 * @param form
	 * @param field
	 * @return CommandConfiguration
	 *         CommandConfiguration 的RequestTask 是ServiceTask, Where 字符串记录在commandContent
	 *         requestParameter 记录着，所需要的Where 条件的parameter
	 *         比如SQL 文是 field = ?, Field2 = ? 的时候。
	 * @throws Exception
	 */
	public CommandConfiguration parseWhereForSyntax(RequestTask whereField, String alias ) throws Exception;
	
}