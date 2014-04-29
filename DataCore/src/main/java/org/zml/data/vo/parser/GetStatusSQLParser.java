package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.GetStatus;
import org.zml.data.vo.bind.Schema;
import org.zml.util.UtilTools;

public class GetStatusSQLParser extends SQLParser implements SQLParserAble
{
	public GetStatusSQLParser( GetStatus element)
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
		if ( !(this.getQueryDefineElement() instanceof GetStatus))
		{
			throw new Exception(" GetStatusSQLParser only parse GetStatus");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("GetStatusSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("GetStatusSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			GetStatus config = (GetStatus)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement ת����GetStatus���� ");
			}
			
			if( config.getLibrary() == null ){
				logger.error("getStatus û�����ö�Ӧ��Library.");
				return;
			}
			
			SQLParserAble libraryAble = SQLParserFactory.getQueryDefineInterpreter(config.getLibrary());
			if( libraryAble == null ){
				logger.error("getStatus��Library û�����ö�Ӧ��SQLParserAble.");
				return;
			}
			libraryAble.loadSchemas(schema, properties);
			
			logger.debug("GetStatusSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("GetStatusSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("GetStatusSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("GetStatusSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}