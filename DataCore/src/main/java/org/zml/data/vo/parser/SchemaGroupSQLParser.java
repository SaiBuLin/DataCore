package org.zml.data.vo.parser;
import java.util.ArrayList;
import java.util.Map;

import org.zml.data.vo.bind.Form;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SchemaGroup;
import org.zml.util.UtilTools;

public class SchemaGroupSQLParser extends SQLParser implements SQLParserAble
{
	public SchemaGroupSQLParser( SchemaGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaGroup))
		{
			throw new Exception(" SchemaGroupSQLParser only parse SchemaGroup");
		}
		result = true;
		return result;
	}
	
	/**
	 * @see override interface 
	 * 
	 */
	@Override
	public void loadSchemas( Map<String, Schema> schema_map, Map<String, Object> properties ) throws Exception{
		logger.debug("SchemaGroupSQLParser ִ��loadSchemas��");
		try{
			if( schema_map == null ){
				throw new NullPointerException("VO ������������Ϊ�ա�");
			}
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			/* ǿ��ת�� */
			logger.debug("loadSchemas ִ�У���queryDefineElementǿ��ת����SchemaGroup.");
			SchemaGroup config = (SchemaGroup)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("ǿ��ת������queryDefineElement ����ת����SchemaGroup��");
			}
			
			logger.debug("loadSchemas ִ�У���Schema ��ȡ����.");
			if( config.getSchema() == null ){
				throw new NullPointerException("Schema û�з��֡�");
			}
			
			
			logger.debug("loadSchemas ִ�У���Schema�� ����Parser ���д���.");
			ArrayList<Schema> vodefines = config.getSchema();
			int mSize = vodefines.size();
			
			logger.debug("loadSchemas ִ�У�ѭ����ȡSchema.");
			for( int ii = 0; ii < mSize; ii++ ){
				Schema vodefine = vodefines.get(ii);
				if( vodefine == null ){
					logger.error("SchemaGroupSQLParser::loadSchemas �׳��쳣�� �쳣����Schema�б��ȡSchema ΪNULL." );
					continue;
				}
				SQLParserAble able = SQLParserFactory.getQueryDefineInterpreter( vodefine );
				if( able == null ){
					logger.error("SchemaGroupSQLParser::loadSchemas �׳��쳣�� �쳣��Schema Parser ���� �ࣺ" + vodefine.getClass().toString() );
					continue;
				}
				/* װ��VO ���� */
				able.loadSchemas(schema_map, properties);
			}
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SchemaGroupSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("SchemaGroupSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SchemaGroupSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}