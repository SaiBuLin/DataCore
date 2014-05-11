package org.zml.data.service.page.request.parser;

import java.util.List;

import org.zml.data.vo.command.bind.CommandConfiguration;

/**
 * 响应请求
 * @author zlmwork
 *
 */
public interface FormsetParserAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	/**
	 * 获得SelectFieldName 列表， 用于调用VO 配置，生成Select 部分的字符串
	 * @return
	 * @throws Exception
	 */
	public List<String> getSelectFieldNames() throws Exception;
	
	
	public CommandConfiguration parserWhereString() throws Exception;
	
}