package org.zml.data.vo.parser;

import java.util.Map;

import org.zml.data.vo.bind.Field;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.data.dataset.bind.NetDataSet;

/**
 * 
 * @author zlmwork
 * @see  V2013.12  
 *       ������2013 �ƶ���������µ����ݷ���
 *       �ڿ����У�����python ����, ����jboss �Ĺ��������п���
 *       �������ӵ����ݴ���
 */
public abstract class SQLParser extends SQLParserTools implements SQLParserAble
{
	protected CTXMLElement queryDefineElement = null;
	public CTXMLElement getQueryDefineElement()
	{
		return queryDefineElement;
	}
	
	public void setQueryDefineElement(CTXMLElement queryDefineElement)
	{
		this.queryDefineElement = queryDefineElement;
	}
	
	/**
	 * ִ��, ��������Ӧ���ݼ���
	 * ��NetDataSet 	 
	 */
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException{
		NetDataSet result = null;
		logger.debug("ִ��VO ������(parser)");
		return result;
	}
	
	/**
	 * ����Command ������
	 * ���д�DataForm �̳е�Form ��
	 */
	public CommandForm parserCommand(VOForm form) throws DataServiceException{		
		
		return null;
	}
	
	@Override
	public CommandForm parserCommand(
			int index,
			VOForm form, 
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws DataServiceException{
		return null;
	}
	
	@Override
	public CommandForm parserCommand(
			VOForm form,
			CommandForm leftForm,
			CommandForm rightForm, 
			TableRelation tableRelation 
			)throws DataServiceException{
		return null;
	}
	
	@Override
	public CommandForm parserCommand(int index,
			VOForm form, 
			CommandForm relationForm) throws DataServiceException{
		return null;
	}
	
	@Override
	public String parserRelationFieldString(
			VOForm form,
			String leftalias,
			String rightalias
			) throws DataServiceException{
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 * ��ö�����Ϣ, �����Ҫ����FormPart ȥʵ��
	 */
	public NetDataSet getColumnsDefine() throws DataServiceException{
		NetDataSet result = null;
		logger.debug("ִ�л��Column�б�");
		return result;
	}
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 * �������������Ϣ
	 */
	public NetDataSet getConditionsDefine() throws DataServiceException{
		NetDataSet result = null;
		logger.debug("ִ�л�������б�");
		return result;
	}
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 */
	public NetDataSet getGroupByDefine() throws DataServiceException{
		NetDataSet result = null;
		logger.debug("ִ�л��Group by �б�");
		return result;
	}
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 */
	public NetDataSet getOrderByDefine() throws DataServiceException{
		NetDataSet result = null;
		logger.debug("ִ�л�� Order by �б�");
		return result;
	}
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 */
	public NetDataSet getLibraryDefine() throws DataServiceException{
		NetDataSet result = null;
		logger.debug("ִ�л�� Library �б�");
		return result;
	}
		
	/**
	 * 
	 * @param dataSet
	 * @throws DataServiceException
	 * ���ݰ�
	 */
	public void filterBind(NetDataSet dataSet) throws DataServiceException{
		logger.debug("�������ݰ�");
	}
	
	/**
	 * 
	 * @param dataSet
	 * @return
	 * @throws DataServiceException
	 */
	public Boolean checkValidate(NetDataSet dataSet) throws DataServiceException{
		Boolean result = true;
		logger.debug("�������ݺϷ��԰�.");
		return result;
	}
	
	@Override
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception{
		logger.debug("ִ�� ��Load Schemas");
	}
	
	@Override
	public void loadSchemas(Schema schema, Map<String, Object> properties) throws Exception{
		logger.debug("ִ�� ��Load Schemas");
	}
	
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException{
		logger.debug(" װ����������.");
	}
	
	
	/* ר����part ���� */
	/**
	 * ��ò�ѯ����ֵ��Columns
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getQueryFields(VOForm form) throws DataServiceException{
		logger.debug(" ���Select Fields.");
		return null;
	}
	
	/**
	 * ��������б�
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getWhereFields(VOForm form) throws DataServiceException{
		return null;
	}
	
	/**
	 * 
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getOrderFields(VOForm form) throws DataServiceException{
		return null;
	}
	
	/**
	 * 
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getGroupByFields(VOForm form) throws DataServiceException{
		return null;
	}
	
	/* ********************************* ר��part ���� */
	/**
	 * ������������Select �������
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	@Override
	public CommandForm parserSelectCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		return null;
	}
	
	/**
	 * ����Where ������������
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	@Override
	public CommandForm parserWhereCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		return null;
	}
	
	
	/**
	 * �������򲿷ֵ�����
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	@Override
	public CommandForm parserOrderCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		return null;
	}
	
	@Override
	public CommandForm parserGroupbyCommand(
			int index,
			String alias, 
			VOForm form) throws DataServiceException{
		return null;
	}
	
	/**
	 * ����DataSet ���ֵ���� ����SQL��Table ����SQL��
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserDataSetStringCommand(VOForm form) throws DataServiceException{
		return null;
	}
	
	
	@Override 
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		
	}
	
	@Override 
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException{
		
	}
	
	@Override 
	public IActionTools parseFormActionTools() throws DataServiceException{
		return null;
	}
	
	@Override 
	public IConnectionAble parseConnection() throws DataServiceException{
		return null;
	}

}