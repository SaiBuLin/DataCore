package org.zml.vo.engine.context;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.zml.schema.bind.Schema;
import org.zml.util.UtilTools;
import org.zml.vo.AIVOEngine;

import java.io.File;


public class VOEngineContext extends AIVOEngine {
	
	/* Schema �Ĺ����б� */
	public static Map<String, Schema> MAP_SCHEMA = new HashMap<String, Schema>(); 
	
	public static List<String> SCHEMA_STORE_PATH_LIST = new ArrayList<String>();
	
	/**
	 * ����voconfig ��Ŀ¼�б�
	 * @param paths
	 * @throws Exception
	 */
	public static void setSchemaStorePathList(List<String> paths )throws Exception{
		if( paths == null ){
			logger.error("VOEngineContext����setShemaStorePathList���� ��ڲ���pathΪ�ա�");
			return;
		}
		
		if( paths.size() == 0 ){
			logger.error("VOEngineContext����setShemaStorePathList���� ��ڲ���pathΪ�ա�");
			return;
		}
		
		if( SCHEMA_STORE_PATH_LIST == null ){
			SCHEMA_STORE_PATH_LIST =  new ArrayList<String>();
		}
		SCHEMA_STORE_PATH_LIST.clear();
		
		
		int mSize = paths.size();
		
		for( int ii = 0; ii < mSize; ii++ ){
			String path = UtilTools.getTrim(paths.get(ii));
			if(UtilTools.isNull(path) ){
				continue;
			}
			
			File file = new File(path);
			
			if( !file.exists() ){
				logger.error("VOEngineContext����setShemaStorePathList����Paths �б���, ����ֵ��" + path + "�����ڣ�����ȷ����");
				continue;
			}
			
			if( !file.isDirectory() ){
				logger.error("VOEngineContext����setShemaStorePathList����Paths �б���, ����ֵ��" + path + "���ǺϷ���·����");
				continue;
			}
			
			if( !file.canRead() ){
				logger.error("VOEngineContext����setShemaStorePathList����Paths �б���, ����ֵ��" + path + "���ܶ�ȡ�������·���Ķ�ȡȨ�ޡ�");
				continue;
			}
			
			logger.debug("VOEngineContext����setShemaStorePathList����Paths �б���, ����ֵ��" + path + "����VO Config ·�������б��С�");
			SCHEMA_STORE_PATH_LIST.add( path );
		}
		
	}
	
	/**
	 * ��VO Config��·��װ��Schema�б�.
	 * @throws Exception
	 */
	public static void loadSchemas() throws Exception{
		if( SCHEMA_STORE_PATH_LIST == null ){
			logger.error("VOEngineContext��loadSchemasִ�д�������vo config ��·���б�Ϊ�գ���ȷ��ִ����setSchemaStorePathList�ķ�����");
		}
		
		int mSize = SCHEMA_STORE_PATH_LIST.size();
		
		for( int ii = 0; ii < mSize; ii++ ){
			
		}
		
	}
	
	private static List<String> readXMLFilesForVOConfig(String path) throws Exception{
		List<String> result = new ArrayList<String>();
		
		return result;
	}
	
	private static  List<Schema> readSchemasFromXMLFiles(List<String> xmlFiles) throws Exception{
		List<Schema> result = new ArrayList<Schema>();
		
		return result;
	}
	
	private static List<Schema> readSchemasFromXMLFile(String xmlFile)throws Exception{
		List<Schema> result = new ArrayList<Schema>();
		
		return result;
	}
	
	
}
