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
 *       赵黎民2013 制定和设计最新的数据服务
 *       在开发中，引入python 语言, 基于jboss 的工作流进行开发
 *       来处理复杂的数据处理
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
		logger.debug("进行数据绑定");
	}
	
	/**
	 * 
	 * @param dataSet
	 * @return
	 * @throws DataServiceException
	 */
	public Boolean checkValidate(NetDataSet dataSet) throws DataServiceException{
		Boolean result = true;
		logger.debug("进行数据合法性绑定.");
		return result;
	}
	
	
	@Override
	public CommandConfiguration parserCommand() throws Exception{
		return null;
	}
	
	

	
	/**
	 * 装载Schema 及数据定义。
	 */
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception{
		
	}
	
	public void loadSchemas(Schema schema, Map<String, Object> properties) throws Exception{
		
	}
	
	/**
	 * 装载属性
	 */
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException{
		
	}
	
	
	
	/**
	 * 装载Field 配置
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