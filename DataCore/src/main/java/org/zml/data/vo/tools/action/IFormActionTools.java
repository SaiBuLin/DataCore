package org.zml.data.vo.tools.action;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.connection.IConnectionAble;

/**
 * 
 * @author zlmwork
 * @see V2013��12 
 *      ��������SQL, ��ִ��.
 */
public interface IFormActionTools extends IActionTools {
	
	/**
	 * ������ڲ�ѯ���ݵ������ִ�
	 * @param voForm        voForm ���������Fields 
	 * @param selectForm    ��ѯColumn ����
	 * @param whereForm     ������
	 * @param orderForm     ����
	 * @param dataset       ����Դ
	 * @return
	 * @throws Exception
	 */
	public String getFromQueryString(VOForm voForm,
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset
			) throws Exception;
	
	/**
	 * ֧�ָ��ӵ�View ��ϵ���ݶ�Ӧ
	 * @param voForm
	 * @param viewForm
	 * @return
	 * @throws Exception
	 */
	public String getFromQueryString(VOForm voForm,
			CommandForm viewForm
			) throws Exception;
	
	/**
	 * ��ø������ݵ������ַ���
	 * @param voForm
	 * @param selectForm
	 * @param whereForm
	 * @param orderForm
	 * @param dataset
	 * @return
	 * @throws Exception
	 */
	public String getFromUpdateString(
			VOForm voForm,
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws Exception;
	
	/**
	 * ��ø������ݣ����룩�������ַ���
	 * @param voForm
	 * @param selectForm
	 * @param whereForm
	 * @param orderForm
	 * @param dataset
	 * @return
	 * @throws Exception
	 */
	public String getFromInsertString(
			VOForm voForm,
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws Exception;
	
	/**
	 * ��ø������ݣ�ɾ�����������ַ���
	 * @param voForm
	 * @param selectForm
	 * @param whereForm
	 * @param orderForm
	 * @param dataset
	 * @return
	 * @throws Exception
	 */
	public String getFromDeleteString(
			VOForm voForm,
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws Exception;
	
	/**
	 * ִ�в�ѯ
	 * @param voForm
	 * @param cmdForm
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeQuery(
			IConnectionAble connection,
			VOForm voForm, CommandForm cmdForm ) throws Exception;
	
	/**
	 * ִ�и���
	 * @param voForm
	 * @param cmdForm
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeUpdate(
			IConnectionAble connection,
			VOForm voForm, 
			CommandForm cmdForm) throws Exception;
	
	/**
	 * ִ�в���
	 * @param voForm
	 * @param cmdForm
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeInsert(
			IConnectionAble connection,
			VOForm voForm, 
			CommandForm cmdForm) throws Exception;
	
	/**
	 * ִ��ɾ��
	 * @param voForm
	 * @param cmdForm
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeDelete(
			IConnectionAble connection,
			VOForm voForm,
			CommandForm cmdForm) throws Exception;
	
	/* 
	 * ���Ӷ�Select���� �� ������Field �����н��д���
	 */
	public String parseSelectFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public String parseSelectFieldForUpdate(String alias, String field, String extendString) throws Exception;
	
	public String parseSelectFieldForInsert(String alias, String field, String extendString) throws Exception;
	
	public String parseSelectFieldForDelete(String alias, String field, String extendString) throws Exception;
	
	public String parseWhereFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public String parseWhereFieldForUpdate(String alias, String field, String extendString) throws Exception;
	
	public String parseWhereFieldForInsert(String alias, String field, String extendString) throws Exception;
	
	public String parseWhereFieldForDelete(String alias, String field, String extendString) throws Exception;
	
	public String parseOrderFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public String parseGroupbyFieldForQuery(String alias, String field, String extendString) throws Exception;

}
