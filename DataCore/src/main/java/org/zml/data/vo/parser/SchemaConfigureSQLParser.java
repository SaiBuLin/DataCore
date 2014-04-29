package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.Form;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SchemaConfigure;
import org.zml.util.UtilTools;

public class SchemaConfigureSQLParser extends SQLParser implements SQLParserAble
{
	public SchemaConfigureSQLParser( SchemaConfigure element)
	{
		setQueryDefineElement(element);
	}
	
	public boolean checkQueryElementComfort() throws Exception
	{
		boolean result = false;
		if ( this.getQueryDefineElement()  == null )
		{
			throw new Exception(" queryDefineElement cannot be null. ");
		}
		if ( !(this.getQueryDefineElement() instanceof SchemaConfigure))
		{
			throw new Exception(" SchemaConfigureSQLParser only parse SchemaConfigure");
		}
		result = true;
		return result;
	}
	
	/**
	 * @see override interface 
	 * 
	 */
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception{
		logger.debug("SchemaConfigureSQLParser ִ��loadSchemas��");
		try{
			if( schema_map == null ){
				throw new NullPointerException("��ڲ���schema_map ������������Ϊ�ա�");
			}
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			/* ǿ��ת�� */
			logger.debug("loadSchemas ִ�У���queryDefineElementǿ��ת����SchemaConfigure.");
			SchemaConfigure config = (SchemaConfigure)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("ǿ��ת������queryDefineElement ����ת����SchemaConfigure��");
			}
			
			logger.debug("loadSchemas ִ�У���Schema ��ȡ����.");
			if( config.getSchema() == null ){
				throw new NullPointerException("Schema û�з��֡�");
			}
			
			logger.debug("loadSchemas ִ�У���Schema ����Parser ���д���.");
			
			SQLParserAble able = SQLParserFactory.getQueryDefineInterpreter( config.getSchema() );
			if( able == null ){
				throw new ClassNotFoundException("Schema ��SQLParser û��ָ����");
			}
			
			/* װ��VO ���� */
			able.loadSchemas(schema_map, properties);
			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SchemaConfigureSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("SchemaConfigureSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SchemaConfigureSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}