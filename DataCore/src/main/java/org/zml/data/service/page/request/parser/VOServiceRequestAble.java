package org.zml.data.service.page.request.parser;

import java.util.List;

import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.RequestTask;

/**
 * 
 * @author zlmwork
 * @see v2013.12 
 * 
 * ��ȡ���������
 */
public interface VOServiceRequestAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	
	/**
	 * �������󣬻��Select ����Field Names ������
	 * VO ���öԱ�
	 * @return
	 * @throws Exception
	 */
	public List<String> listSelectFieldNames() throws Exception;
	
	/**
	 * ����Request �����������ֶ��б�
	 * @return
	 * @throws Exception
	 */
	public List<String> listWhereFieldNames() throws Exception;
	
	/**
	 * ����Order by ����
	 * @return
	 * @throws Exception
	 */
	public List<String> listOrderByFieldNames() throws Exception;
	
	/**
	 * ���Group by ����
	 * @return
	 * @throws Exception
	 */
	public List<String> listGroupByFieldNames() throws Exception;
	
	/**
	 * ����requestTask ����Ϣ��ConditionSyntax ����where ����
	 * ���ҷ�����Ҫ��command parameter �б�
	 * @param form
	 * @param field
	 * @return CommandConfiguration
	 *         CommandConfiguration ��RequestTask ��ServiceTask, Where �ַ�����¼��commandContent
	 *         requestParameter ��¼�ţ�����Ҫ��Where ������parameter
	 *         ����SQL ���� field = ?, Field2 = ? ��ʱ��
	 * @throws Exception
	 */
	public CommandConfiguration parseWhereForSyntax(RequestTask whereField, String alias ) throws Exception;
	
}