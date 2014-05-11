package org.zml.data.service.page.request.parser;

import java.util.List;

import org.zml.data.vo.command.bind.CommandConfiguration;

/**
 * ��Ӧ����
 * @author zlmwork
 *
 */
public interface FormsetParserAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	/**
	 * ���SelectFieldName �б� ���ڵ���VO ���ã�����Select ���ֵ��ַ���
	 * @return
	 * @throws Exception
	 */
	public List<String> getSelectFieldNames() throws Exception;
	
	
	public CommandConfiguration parserWhereString() throws Exception;
	
}