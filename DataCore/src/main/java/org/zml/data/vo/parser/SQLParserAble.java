package org.zml.data.vo.parser;

import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.Field;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.TableRelation;

import java.util.Map;


/**
 * 
 * @author zlmwork
 * @see  V2013.12  
 *       ������2013 �ƶ���������µ����ݷ���
 *       �ڿ����У�����python Ԥ��, ����jboss �Ĺ��������п���
 *       �������ӵ����ݴ���*
 */
public interface SQLParserAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	/**
	 * 	 
	 * ִ��, �������б�form�� ����װ����Ҫ��������⡣
	 * ��	
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException;
	
	/**
	 * ��������ӦCommand �ַ������洢��Map<String,String> �С�
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserCommand( 
			VOForm form) throws DataServiceException;
	
	public CommandForm parserCommand(
			int index,
			VOForm form, 
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws DataServiceException;
	
	public CommandForm parserCommand(
			VOForm form,
			CommandForm leftForm,
			CommandForm rightForm, 
			TableRelation tableRelation 
			)throws DataServiceException;
	
	public CommandForm parserCommand(
			int index,
			VOForm form, 
			CommandForm relationForm) throws DataServiceException;
	
	
	public String parserRelationFieldString(
			VOForm form,
			String leftalias,
			String rightalias
			) throws DataServiceException;
	
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 * ��ö�����Ϣ, �����Ҫ����FormPart ȥʵ��
	 */
	public NetDataSet getColumnsDefine() throws DataServiceException;
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 * �������������Ϣ
	 */
	public NetDataSet getConditionsDefine() throws DataServiceException;
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 */
	public NetDataSet getGroupByDefine() throws DataServiceException;
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 */
	public NetDataSet getOrderByDefine() throws DataServiceException;
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 */
	public NetDataSet getLibraryDefine() throws DataServiceException;
		
	/**
	 * 
	 * @param dataSet
	 * @throws DataServiceException
	 * ���ݰ�
	 */
	public void filterBind(NetDataSet dataSet) throws DataServiceException;
	
	/**
	 * 
	 * @param dataSet
	 * @return
	 * @throws DataServiceException
	 */
	public Boolean checkValidate(NetDataSet dataSet) throws DataServiceException;
	
	/**
	 * װ��Schema �����ݶ��塣
	 */
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception;
	
	public void loadSchemas(Schema schema, Map<String, Object> properties) throws Exception;
	
	/**
	 * װ������
	 */
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException;
	
	
	/* ר����part ���� */
	/**
	 * ��ò�ѯ����ֵ��Columns
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getQueryFields(VOForm form) throws DataServiceException;
	
	/**
	 * ��������б�
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getWhereFields(VOForm form) throws DataServiceException;
	
	/**
	 * 
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getOrderFields(VOForm form) throws DataServiceException;
	
	/**
	 * 
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getGroupByFields(VOForm form) throws DataServiceException;
	
	/* ********************************* ר��part ���� */
	
	/**
	 * ������������Select �������
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserSelectCommand(
			int index,
			String alias, 
			VOForm form) throws DataServiceException;
	
	/**
	 * ����Where ������������
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserWhereCommand(
			int index,
			String alias, 
			VOForm form) throws DataServiceException;
	
	
	/**
	 * �������򲿷ֵ�����
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserOrderCommand(
			int index,
			String alias, 
			VOForm form) throws DataServiceException;
	
	/**
	 * ����Group by �Ĳ���
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserGroupbyCommand(
			int index,
			String alias, 
			VOForm form) throws DataServiceException;
	
	/**
	 * ����DataSet ���ֵ���� ����SQL��Table ����SQL��
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserDataSetStringCommand(VOForm form) throws DataServiceException; 
	
	/**
	 * װ��Field ����
	 * @param fieldProperties
	 * @throws DataServiceException
	 */
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException;
	
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException;
	
	
	public IActionTools parseFormActionTools() throws DataServiceException;
	
	public IConnectionAble parseConnection() throws DataServiceException;
	
	
	
}