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
 *       赵黎民2013 制定和设计最新的数据服务
 *       在开发中，引入python 预言, 基于jboss 的工作流进行开发
 *       来处理复杂的数据处理*
 */
public interface SQLParserAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	/**
	 * 	 
	 * 执行, 是属性列表form， 用来装载需要处理的特殊。
	 * 表单	
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException;
	
	/**
	 * 创建出对应Command 字符串，存储在Map<String,String> 中。
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
	 * 获得定义信息, 这个主要是有FormPart 去实现
	 */
	public NetDataSet getColumnsDefine() throws DataServiceException;
	
	/**
	 * 
	 * @return
	 * @throws DataServiceException
	 * @author zlmwork 
	 * 获得条件定义信息
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
	 * 数据绑定
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
	 * 装载Schema 及数据定义。
	 */
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception;
	
	public void loadSchemas(Schema schema, Map<String, Object> properties) throws Exception;
	
	/**
	 * 装载属性
	 */
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException;
	
	
	/* 专用于part 部分 */
	/**
	 * 获得查询返回值得Columns
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public Map<String, Field> getQueryFields(VOForm form) throws DataServiceException;
	
	/**
	 * 获得条件列表
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
	
	/* ********************************* 专用part 部分 */
	
	/**
	 * 产生用来进行Select 的命令部分
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserSelectCommand(
			int index,
			String alias, 
			VOForm form) throws DataServiceException;
	
	/**
	 * 产生Where 条件部分命令
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserWhereCommand(
			int index,
			String alias, 
			VOForm form) throws DataServiceException;
	
	
	/**
	 * 产生排序部分的命令
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserOrderCommand(
			int index,
			String alias, 
			VOForm form) throws DataServiceException;
	
	/**
	 * 产生Group by 的部分
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserGroupbyCommand(
			int index,
			String alias, 
			VOForm form) throws DataServiceException;
	
	/**
	 * 产生DataSet 部分的命令， 比如SQL问Table 或者SQL文
	 * @param form
	 * @return
	 * @throws DataServiceException
	 */
	public CommandForm parserDataSetStringCommand(VOForm form) throws DataServiceException; 
	
	/**
	 * 装载Field 配置
	 * @param fieldProperties
	 * @throws DataServiceException
	 */
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException;
	
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException;
	
	
	public IActionTools parseFormActionTools() throws DataServiceException;
	
	public IConnectionAble parseConnection() throws DataServiceException;
	
	
	
}