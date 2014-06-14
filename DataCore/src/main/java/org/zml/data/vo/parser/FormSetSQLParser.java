package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.FormSet;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class FormSetSQLParser extends SQLParser implements SQLParserAble
{
	public FormSetSQLParser( FormSet element)
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
		if ( !(this.getQueryDefineElement() instanceof FormSet))
		{
			throw new Exception(" FormSetSQLParser only parse FormSet");
		}
		result = true;
		return result;
	}
	
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("FormSetSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("FormSetSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			FormSet config = (FormSet)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement ת����FormSet���� ");
			}
			
			if( config.getForm() == null ){
				logger.error("FormSet û�����ö�Ӧ��form.");
				return;
			}
			
			SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter(config.getForm());
			if( formAble == null ){
				logger.error("FormSet��form û�����ö�Ӧ��SQLParserAble.");
				return;
			}
			formAble.loadSchemas(schema, properties);
			
			logger.debug("FormSetSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormSetSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FormSetSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormSetSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}