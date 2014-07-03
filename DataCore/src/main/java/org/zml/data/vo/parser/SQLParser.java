package org.zml.data.vo.parser;

import java.util.Map;

import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.command.bind.CommandConfiguration;
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
	public CommandConfiguration parserCommand() throws Exception{
		return null;
	}
	
	

	
	/**
	 * װ��Schema �����ݶ��塣
	 */
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception{
		
	}
	
	public void loadSchemas(Schema schema, Map<String, Object> properties) throws Exception{
		
	}
	
	/**
	 * װ������
	 */
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException{
		
	}
	
	
	
	/**
	 * װ��Field ����
	 * @param fieldProperties
	 * @throws DataServiceException
	 */
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		
	}
	
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException{
		
	}
	
	/**
	 * Parser ActionTools
	 * @return
	 * @throws DataServiceException
	 */
	public IActionTools parseFormActionTools() throws DataServiceException{
		return null;
	}
	
	public IConnectionAble parseConnection() throws DataServiceException{
		return null;
	}
	

}