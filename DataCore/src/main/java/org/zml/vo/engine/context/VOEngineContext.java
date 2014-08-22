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
	
	/* Schema 的管理列表 */
	public static Map<String, Schema> MAP_SCHEMA = new HashMap<String, Schema>(); 
	
	public static List<String> SCHEMA_STORE_PATH_LIST = new ArrayList<String>();
	
	/**
	 * 设置voconfig 的目录列表
	 * @param paths
	 * @throws Exception
	 */
	public static void setSchemaStorePathList(List<String> paths )throws Exception{
		if( paths == null ){
			logger.error("VOEngineContext调用setShemaStorePathList错误。 入口参数path为空。");
			return;
		}
		
		if( paths.size() == 0 ){
			logger.error("VOEngineContext调用setShemaStorePathList错误。 入口参数path为空。");
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
				logger.error("VOEngineContext调用setShemaStorePathList错误。Paths 列表中, 其中值：" + path + "不存在，请重确定。");
				continue;
			}
			
			if( !file.isDirectory() ){
				logger.error("VOEngineContext调用setShemaStorePathList错误。Paths 列表中, 其中值：" + path + "不是合法的路径。");
				continue;
			}
			
			if( !file.canRead() ){
				logger.error("VOEngineContext调用setShemaStorePathList错误。Paths 列表中, 其中值：" + path + "不能读取，请检查该路径的读取权限。");
				continue;
			}
			
			logger.debug("VOEngineContext调用setShemaStorePathList错误。Paths 列表中, 其中值：" + path + "加入VO Config 路径配置列表中。");
			SCHEMA_STORE_PATH_LIST.add( path );
		}
		
	}
	
	/**
	 * 从VO Config的路径装载Schema列表.
	 * @throws Exception
	 */
	public static void loadSchemas() throws Exception{
		if( SCHEMA_STORE_PATH_LIST == null ){
			logger.error("VOEngineContext的loadSchemas执行错误，其中vo config 的路径列表为空，请确定执行了setSchemaStorePathList的方法。");
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
