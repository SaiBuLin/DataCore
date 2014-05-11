package org.zml.data.vo.parser;

import java.util.Map;

import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.tools.xml.parser.CTXMLElement;
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