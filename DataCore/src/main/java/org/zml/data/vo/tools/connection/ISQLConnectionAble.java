package org.zml.data.vo.tools.connection;

import java.sql.Connection;
import java.util.Map;
/**
 * 
 * @author zlmwork
 * @see v2013.12
 *      �������ݿ�����ӣ� ����Sql Server, MySQL, Oracle ,DB2 ��
 *      Ĭ�ϲ���
 */
public interface ISQLConnectionAble extends IConnectionAble {
	
	
	public Connection getConnection(Map<String,Object> properties) throws Exception;
}
