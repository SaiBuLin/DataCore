package org.zml.form.sql.parser;

import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.data.SQLString;

public interface FormSQLParserAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	/**
	 * ����fieldcode ��ò�ѯ�õ�field
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public FieldInfo getSelectField(FieldDefine field) throws Exception;
	
	/**
	 * ���order Field 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public FieldInfo getOrderField(FieldDefine field) throws Exception;
	
	/**
	 * ���GroupField �ֶ�
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public FieldInfo getGroupField(FieldDefine field) throws Exception;
	
	/**
	 * �������
	 * @param alias
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public SQLString parserWhereString(  List<FieldDefine> fields  ) throws Exception;
}