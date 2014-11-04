package org.zml.form.sql.parser;

import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.data.SQLString;

public interface FormSQLParserAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	/**
	 * 根据fieldcode 获得查询用的field
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public FieldInfo getSelectField(FieldDefine field) throws Exception;
	
	/**
	 * 获得order Field 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public FieldInfo getOrderField(FieldDefine field) throws Exception;
	
	/**
	 * 获得GroupField 字段
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public FieldInfo getGroupField(FieldDefine field) throws Exception;
	
	/**
	 * 获得条件
	 * @param alias
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public SQLString parserWhereString(  List<FieldDefine> fields  ) throws Exception;
}