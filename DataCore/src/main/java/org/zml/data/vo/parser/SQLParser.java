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
	
	/**
	 * 执行, 并返回相应数据集合
	 * 在NetDataSet 	 
	 */
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException{
		NetDataSet result = null;
		logger.debug("执行VO 解释器(parser)");
		return result;
	}
	
	/**
	 * 产生Command 命令字
	 * 所有从DataForm 继承的Form 都
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
	 * 获得定义信息, 这个主要是有FormPart 去实现
	 */
	public NetDataSet getColumnsDefine() throws DataServiceException{
		NetDataSet result = null;
		logger.debug("执行获得Column列表。");
		return result;
	}
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 * 获得条件定义信息
	 */
	public NetDataSet getConditionsDefine() throws DataServiceException{
		NetDataSet result = null;
		logger.debug("执行获得条件列表。");
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
		logger.debug("执行获得Group by 列表。");
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
		logger.debug("执行获得 Order by 列表。");
		return result;
	}
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 */
	public NetDataSet getLibraryDefine() throws DataServiceException{
		NetDataSet result = null;
		logger.debug("执行获得 Library 列表。");
		return result;
	}
		
	/**
	 * 
	 * @param dataSet
	 * @throws DataServiceException
	 * 数据绑定
	 */
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
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception{
		logger.debug("执行 ：Load Schemas");
	}
	
	@Override
	public void loadSchemas(Schema schema, Map<String, Object> properties) throws Exception{
		logger.debug("执行 ：Load Schemas");
	}
	
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException{
		logger.debug(" 装载属性配置.");
	}
	
	
	/* 专用于part 部分 */
	/**
	 * 获得查询返回值得Columns
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getQueryFields(VOForm form) throws DataServiceException{
		logger.debug(" 获得Select Fields.");
		return null;
	}
	
	/**
	 * 获得条件列表
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
	
	/* ********************************* 专用part 部分 */
	/**
	 * 产生用来进行Select 的命令部分
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
	 * 产生Where 条件部分命令
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
	 * 产生排序部分的命令
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
	 * 产生DataSet 部分的命令， 比如SQL问Table 或者SQL文
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