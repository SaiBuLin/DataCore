package org.zml.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zml.schema.bind.SchemaConfigure;
import org.zml.util.UtilTools;

/**
 * DataServiveEngine 是全新的DataServie 引擎，用来进行数据映射，绑定，更新。
 * 
 * @author zlmwork
 *
 */
public class DataServiceEngine extends DataServiceTools {
	
	private static DataServiceEngine instance = null;
	
	protected Map<String, SchemaConfigure> Data_Service_Configuration_Engines = new HashMap<String, SchemaConfigure>();
	
	private List<String> schemaFilePaths = new ArrayList<String>();				/*存放schema 路径, 支持存储多个Path*/
		
	protected DataServiceEngine(){
		
	}
	
	public static DataServiceEngine getInstance(){
		logger.debug("DataServiceEngine 执行getInstance。 ");
		if( instance == null ){
			instance = new DataServiceEngine();
		}
		return instance;
	}
	
	public void pushSchemaPath(String path)throws Exception{
		if(UtilTools.isNull(path)){
			logger.error("入口参数path 为空，");
			throw new java.io.FileNotFoundException("入口参数path 为空，");
		}
		
		String realPath = UtilTools.getTrim(path);
		
		java.io.File fileinfo = new java.io.File(realPath);
		
		if( !fileinfo.isAbsolute() ){
			logger.error("Schem Path:" + realPath + "不是绝对路径，装载Schema 需要志明绝对路径。");
			throw new java.io.FileNotFoundException("Schem Path:" + realPath + "不是绝对路径，装载Schema 需要志明绝对路径。");
		}
		
		if( fileinfo.isFile() ){
			logger.error("Schem Path:" + realPath + "是一个路径。装载Schema 需要志明绝对路径。");
			throw new java.io.FileNotFoundException("Schem Path:" + realPath + "是一个路径。装载Schema 需要志明绝对路径。");
		}
		
		if( !fileinfo.isDirectory() ){
			logger.error("Schem Path:" + realPath + "不是路径，装载Schema 需要志明绝对路径。");
			throw new java.io.FileNotFoundException("Schem Path:" + realPath + "不是路径，装载Schema 需要志明绝对路径。");
		}
		
		if( fileinfo.isHidden() ){
			logger.warn("Schem Path:" + realPath + "是隐藏路径，请确认。");
		}
		
		if( schemaFilePaths == null ){
			logger.warn("对象schemaFilePaths 为null. 这个错误请检查系统是否出现问题。" );
			schemaFilePaths = new ArrayList<String>();
		}
		
	
		boolean isExists = false;
		
		for(String setpath : schemaFilePaths ){
			String tmpStepaht = UtilTools.getTrim( setpath );
			if( UtilTools.isNull(tmpStepaht)) continue;
			if( tmpStepaht.equalsIgnoreCase(realPath)){
				isExists = true;
			}
		}
		
		if( !isExists ){
			logger.debug("将新的Schema Path 加入列表中。");
			schemaFilePaths.add( realPath );
		}
		
	}
	
	public void clearSchemas(){
		if( schemaFilePaths != null ){
			schemaFilePaths.clear();
		}
	}
	
	
	/**
	 * 装载Schema
	 * @throws Exception
	 */
	public void loadSchema() throws Exception{
		
		
		
	}
	
	
}
