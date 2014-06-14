package org.zml.data.vo.tools.action;

import org.zml.data.vo.command.bind.RequestTask;

/**
 * 
 * @author zlmwork
 * @see V2013。12 
 *      用来创建SQL, 并执行.
 */
public interface IFormActionTools extends IActionTools {

	/**
	 * 用来生成Select 部分的字段
	 * @param alias
	 * @param field
	 * @param extendString
	 * @return
	 * @throws Exception
	 */
	public RequestTask parseSelectFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	/**
	 * 用来生成的字段的Update 部分用来更新用
	 * @param alias
	 * @param field
	 * @param extendString
	 * @return
	 * @throws Exception
	 */
	public RequestTask parseSelectFieldForUpdate(String alias, String field, String extendString) throws Exception;
	
	/**
	 * 用来生成插入部分
	 * @param alias
	 * @param field
	 * @param extendString
	 * @return
	 * @throws Exception
	 */
	public RequestTask parseSelectFieldForInsert(String alias, String field, String extendString) throws Exception;
	
	/**
	 * 插入部分的Value 设置
	 * @param alias
	 * @param field
	 * @param extendString
	 * @return
	 * @throws Exception
	 */
	public RequestTask parseSelectFieldForInsertValues(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseSelectFieldForDelete(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseWhereFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseWhereFieldForUpdate(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseWhereFieldForInsert(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseWhereFieldForDelete(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseOrderFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseGroupbyFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	
	public RequestTask parserCommandForQuery(RequestTask selectTask, 
			RequestTask whereTask, 
			RequestTask orderbyTask, 
			RequestTask groupbyTask,
			RequestTask dataset ) throws Exception;
	
	public RequestTask parserCommandForInsert(
			RequestTask selectTask, 
			RequestTask valuesTask, 
			RequestTask dataset ) throws Exception;
	
	public RequestTask parserCommandForDelete(
			RequestTask whereTask, 			
			RequestTask dataset ) throws Exception;
	
	public RequestTask parserCommandForUpdate(RequestTask selectTask, 
			RequestTask whereTask, 
			RequestTask dataset ) throws Exception;
	
	/**
	 * 用来生成Relation 部分的
	 * @return
	 * @throws Exception
	 */
	public RequestTask parserCommandForRelationShip(
			RequestTask left, 
			RequestTask right
			) throws Exception;

}
