package org.zml.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zml.schema.bind.SchemaConfigure;
import org.zml.util.UtilTools;

/**
 * DataServiveEngine ��ȫ�µ�DataServie ���棬������������ӳ�䣬�󶨣����¡�
 * 
 * @author zlmwork
 *
 */
public class DataServiceEngine extends DataServiceTools {
	
	private static DataServiceEngine instance = null;
	
	protected Map<String, SchemaConfigure> Data_Service_Configuration_Engines = new HashMap<String, SchemaConfigure>();
	
	private List<String> schemaFilePaths = new ArrayList<String>();				/*���schema ·��, ֧�ִ洢���Path*/
		
	protected DataServiceEngine(){
		
	}
	
	public static DataServiceEngine getInstance(){
		logger.debug("DataServiceEngine ִ��getInstance�� ");
		if( instance == null ){
			instance = new DataServiceEngine();
		}
		return instance;
	}
	
	public void pushSchemaPath(String path)throws Exception{
		if(UtilTools.isNull(path)){
			logger.error("��ڲ���path Ϊ�գ�");
			throw new java.io.FileNotFoundException("��ڲ���path Ϊ�գ�");
		}
		
		String realPath = UtilTools.getTrim(path);
		
		java.io.File fileinfo = new java.io.File(realPath);
		
		if( !fileinfo.isAbsolute() ){
			logger.error("Schem Path:" + realPath + "���Ǿ���·����װ��Schema ��Ҫ־������·����");
			throw new java.io.FileNotFoundException("Schem Path:" + realPath + "���Ǿ���·����װ��Schema ��Ҫ־������·����");
		}
		
		if( fileinfo.isFile() ){
			logger.error("Schem Path:" + realPath + "��һ��·����װ��Schema ��Ҫ־������·����");
			throw new java.io.FileNotFoundException("Schem Path:" + realPath + "��һ��·����װ��Schema ��Ҫ־������·����");
		}
		
		if( !fileinfo.isDirectory() ){
			logger.error("Schem Path:" + realPath + "����·����װ��Schema ��Ҫ־������·����");
			throw new java.io.FileNotFoundException("Schem Path:" + realPath + "����·����װ��Schema ��Ҫ־������·����");
		}
		
		if( fileinfo.isHidden() ){
			logger.warn("Schem Path:" + realPath + "������·������ȷ�ϡ�");
		}
		
		if( schemaFilePaths == null ){
			logger.warn("����schemaFilePaths Ϊnull. �����������ϵͳ�Ƿ�������⡣" );
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
			logger.debug("���µ�Schema Path �����б��С�");
			schemaFilePaths.add( realPath );
		}
		
	}
	
	public void clearSchemas(){
		if( schemaFilePaths != null ){
			schemaFilePaths.clear();
		}
	}
	
	
	/**
	 * װ��Schema
	 * @throws Exception
	 */
	public void loadSchema() throws Exception{
		
		
		
	}
	
	
}
