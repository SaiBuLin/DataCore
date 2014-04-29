package org.zml.data.vo.tools.connection.impl;

import java.sql.Connection;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.tools.connection.ISQLConnectionAble;

public class DefaultDBServerConnectionTool implements ISQLConnectionAble {

	@Override
	public NetDataSet execute(Map<String, String> command,
			Map<String, Object> properties) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(Map<String, Object> properties)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
