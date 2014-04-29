package org.zml.data.vo.tools.connection;

import java.sql.Connection;
import java.util.Map;
/**
 * 
 * @author zlmwork
 * @see v2013.12
 *      用于数据库的连接， 包括Sql Server, MySQL, Oracle ,DB2 等
 *      默认采用
 */
public interface ISQLConnectionAble extends IConnectionAble {
	
	
	public Connection getConnection(Map<String,Object> properties) throws Exception;
}
