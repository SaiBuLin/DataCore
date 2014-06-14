package org.zml.data.service.page.request.parser;

import java.util.List;

import org.zml.data.vo.bind.Field;
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
	public List<Field> getSelectFields() throws Exception;
	
	/**
	 * �������Where Fields 
	 * @return
	 * @throws Exception
	 */
	public List<Field> getWhereFields() throws Exception;
	
	/**
	 * ���Order by Fields
	 * @return
	 * @throws Exception
	 */
	public List<Field> getOrderByFields() throws Exception;
	
	/**
	 * ���Group by Fields 
	 * @return
	 * @throws Exception
	 */
	public List<Field> getGroupbyFields() throws Exception;
	 
	public CommandConfiguration parserWhereString() throws Exception;
	
}