package org.zml.data.vo.tools.connection;

import org.zml.data.dataset.bind.NetDataSet;
import java.util.Map;
/**
 * 
 * @author zlmwork
 * @see V2013.12 用来进行数据连接
 * 
 * 连接，主要应用与数据
 */
public interface IConnectionAble {
	
	/**
	 * 需要在Connection 中进行执行，并返回必要
	 * @param command      需要执行的命令
	 * @param properties
	 * @return
	 * @throws Exception
	 */
	public NetDataSet execute(Map<String,String> command,
			Map<String, Object> properties) throws Exception;
}
