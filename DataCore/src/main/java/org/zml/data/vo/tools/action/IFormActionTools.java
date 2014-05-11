package org.zml.data.vo.tools.action;

import org.zml.data.vo.command.bind.RequestTask;

/**
 * 
 * @author zlmwork
 * @see V2013。12 
 *      用来创建SQL, 并执行.
 */
public interface IFormActionTools extends IActionTools {
	
	/* 
	 * 增加对Select处理 ， 用来在Field 处理中进行处理
	 */
	public RequestTask parseSelectFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseSelectFieldForUpdate(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseSelectFieldForInsert(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseSelectFieldForInsertValues(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseSelectFieldForDelete(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseWhereFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseWhereFieldForUpdate(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseWhereFieldForInsert(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseWhereFieldForDelete(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseOrderFieldForQuery(String alias, String field, String extendString) throws Exception;
	
	public RequestTask parseGroupbyFieldForQuery(String alias, String field, String extendString) throws Exception;

}
