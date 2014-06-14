package org.zml.data.vo.tools.connection.impl;

import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.tools.connection.IConnectionAble;

/**
 * 执行Service Connection 执行想特殊的服务器端进行请求，用来进行获得必要的数据。
 * @author zlmwork
 *
 */
public class DefaultServiceConnectionTools implements IConnectionAble {

	@Override
	public NetDataSet execute(CommandConfiguration command,
			Map<String, Object> properties) throws Exception{
		return null;
	}


}
