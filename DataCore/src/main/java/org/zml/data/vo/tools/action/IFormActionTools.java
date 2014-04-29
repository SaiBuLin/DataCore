package org.zml.data.vo.tools.action;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.connection.IConnectionAble;

/**
 * 
 * @author zlmwork
 * @see V2013。12 
 *      用来创建SQL, 并执行.
 */
public interface IFormActionTools extends IActionTools {
	
	/**
	 * 获得用于查询数据的命令字串
	 * @param voForm        voForm 请求所需的Fields 
	 * @param selectForm    查询Column 部分
	 * @param whereForm     条件类
	 * @param orderForm     排序
	 * @param dataset       数据源
	 * @return
	 * @throws Exception
	 */
	public String getFromQueryString(VOForm voForm,
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset
			) throws Exception;
	
	/**
	 * 支持复杂的View 关系数据对应
	 * @param voForm
	 * @param viewForm
	 * @return
	 * @throws Exception
	 */
	public String getFromQueryString(VOForm voForm,
			CommandForm viewForm
			) throws Exception;
	
	/**
	 * 获得更新数据的命令字符串
	 * @param voForm
	 * @param selectForm
	 * @param whereForm
	 * @param orderForm
	 * @param dataset
	 * @return
	 * @throws Exception
	 */
	public String getFromUpdateString(
			VOForm voForm,
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws Exception;
	
	/**
	 * 获得更新数据（插入）的命令字符串
	 * @param voForm
	 * @param selectForm
	 * @param whereForm
	 * @param orderForm
	 * @param dataset
	 * @return
	 * @throws Exception
	 */
	public String getFromInsertString(
			VOForm voForm,
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws Exception;
	
	/**
	 * 获得更新数据（删除）的命令字符串
	 * @param voForm
	 * @param selectForm
	 * @param whereForm
	 * @param orderForm
	 * @param dataset
	 * @return
	 * @throws Exception
	 */
	public String getFromDeleteString(
			VOForm voForm,
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws Exception;
	
	/**
	 * 执行查询
	 * @param voForm
	 * @param cmdForm
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeQuery(
			IConnectionAble connection,
			VOForm voForm, CommandForm cmdForm ) throws Exception;
	
	/**
	 * 执行更新
	 * @param voForm
	 * @param cmdForm
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeUpdate(
			IConnectionAble connection,
			VOForm voForm, 
			CommandForm cmdForm) throws Exception;
	
	/**
	 * 执行插入
	 * @param voForm
	 * @param cmdForm
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeInsert(
			IConnectionAble connection,
			VOForm voForm, 
			CommandForm cmdForm) throws Exception;
	
	/**
	 * 执行删除
	 * @param voForm
	 * @param cmdForm
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeDelete(
			IConnectionAble connection,
			VOForm voForm,
			CommandForm cmdForm) throws Exception;
	
	/* 
	 * 增加对Select处理 ， 用来在Field 处理中进行处理
	 */
	public String parseSelectFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public String parseSelectFieldForUpdate(String alias, String field, String extendString) throws Exception;
	
	public String parseSelectFieldForInsert(String alias, String field, String extendString) throws Exception;
	
	public String parseSelectFieldForDelete(String alias, String field, String extendString) throws Exception;
	
	public String parseWhereFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public String parseWhereFieldForUpdate(String alias, String field, String extendString) throws Exception;
	
	public String parseWhereFieldForInsert(String alias, String field, String extendString) throws Exception;
	
	public String parseWhereFieldForDelete(String alias, String field, String extendString) throws Exception;
	
	public String parseOrderFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public String parseGroupbyFieldForQuery(String alias, String field, String extendString) throws Exception;

}
