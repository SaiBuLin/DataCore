package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.bind.Form;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.VISchema;
import org.zml.util.UtilTools;

public class VISchemaSQLParser extends SQLParser implements SQLParserAble
{
	public VISchemaSQLParser( VISchema element)
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
		if ( !(this.getQueryDefineElement() instanceof VISchema))
		{
			throw new Exception(" VISchemaSQLParser only parse VISchema");
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
		logger.debug("VOSchemaSQLParser ִ��loadSchemas��");
		try{
			if( schema_map == null ){
				throw new NullPointerException("��ڲ���schema_map ������������Ϊ�ա�");
			}
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			
			/* ǿ��ת�� */
			logger.debug("loadSchemas ִ�У���queryDefineElementǿ��ת����VISchema.");
			VISchema config = (VISchema)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("ǿ��ת������queryDefineElement ����ת����VOSchema��");
			}
			
			if( UtilTools.isNull( config.getCode()) ){
				throw new Exception("VOSchema ��������code.");
			}
			
			String indexCode = UtilTools.getTrim(  config.getCode() );
			
			logger.debug("loadSchemas ִ�У���VOSchema ��ȡ����.");
			if( config.getForm() == null ){
				throw new NullPointerException("Form���� û�з��֡�");
			}
			
			logger.debug("loadSchemas ִ�У���Schema ����Parser ���д���.");
			
			SQLParserAble able = SQLParserFactory.getQueryDefineInterpreter( config.getForm() );
			if( able == null ){
				throw new ClassNotFoundException("Schema ��SQLParser û��ָ����");
			}
			
			Map<String, Object> privateproperties = new HashMap<String, Object>();
			if( properties != null ){
				privateproperties.putAll( properties );
			}
			if( config.getActionTools() != null ){
				privateproperties.put(PROPERTY_KEY_ACTION_TOOL, config.getActionTools());
			}
			
			Map<String, Map<String,Form>> privatevo_map  = new HashMap<String, Map<String,Form>>();
			Map<String,Form> intelMap = new HashMap<String,Form>();
			privatevo_map.put(indexCode, intelMap );
			
			/* װ��VO ���� */
			able.loadSchemas(config, privateproperties);
			
			schema_map.put(indexCode,config);
			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("VISchemaSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("VISchemaSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("VISchemaSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}