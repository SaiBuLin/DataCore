package org.zml.data.vo.parser;

import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.Field;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.command.bind.CommandConfiguration;

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
	 * ����
	 * @return
	 * @throws Exception
	 */
	public CommandConfiguration parserCommand() throws Exception;
	
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
	
	
	
	/**
	 * װ��Field ����
	 * @param fieldProperties
	 * @throws DataServiceException
	 */
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException;
	
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException;
	
	/**
	 * Parser ActionTools
	 * @return
	 * @throws DataServiceException
	 */
	public IActionTools parseFormActionTools() throws DataServiceException;
	
	public IConnectionAble parseConnection() throws DataServiceException;
	
	
	
}