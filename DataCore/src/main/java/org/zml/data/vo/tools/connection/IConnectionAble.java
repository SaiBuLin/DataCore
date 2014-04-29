package org.zml.data.vo.tools.connection;

import org.zml.data.dataset.bind.NetDataSet;
import java.util.Map;
/**
 * 
 * @author zlmwork
 * @see V2013.12 ����������������
 * 
 * ���ӣ���ҪӦ��������
 */
public interface IConnectionAble {
	
	/**
	 * ��Ҫ��Connection �н���ִ�У������ر�Ҫ
	 * @param command      ��Ҫִ�е�����
	 * @param properties
	 * @return
	 * @throws Exception
	 */
	public NetDataSet execute(Map<String,String> command,
			Map<String, Object> properties) throws Exception;
}
