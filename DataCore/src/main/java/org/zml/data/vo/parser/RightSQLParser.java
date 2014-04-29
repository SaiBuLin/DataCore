package org.zml.data.vo.parser;
import java.util.Map;
import org.zml.data.vo.bind.Right;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class RightSQLParser extends SQLParser implements SQLParserAble
{
	public RightSQLParser( Right element)
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
		if ( !(this.getQueryDefineElement() instanceof Right))
		{
			throw new Exception(" RightSQLParser only parse Right");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("RightSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("RightSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			Right config = (Right)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement ת����Right���� ");
			}
			
			if( config.getForm() == null ){
				logger.error("Right û�����ö�Ӧ��form.");
				return;
			}
			
			SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter(config.getForm());
			if( formAble == null ){
				logger.error("Right��form û�����ö�Ӧ��SQLParserAble.");
				return;
			}
			formAble.loadSchemas(schema, properties);
			
			logger.debug("RightSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RightSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RightSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RightSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties( FieldsConfig fieldProperties) throws DataServiceException{
		try{
			logger.debug("RightSQLParser��ʼִ��loadFieldsProperties��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return;
			}
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties ��ڲ���fieldPropertiesΪ�ա�");
			}
			
			Right config = (Right)this.queryDefineElement;
			
			if( config.getForm() == null ){
				throw new Exception("Right ������form û�����á�");
			}
			
			SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( config.getForm() );
			if( formpartAble == null ){
				throw new Exception("Right������formû�ж�Ӧ��ParserTools�ࡣ");
			}
			
			formpartAble.loadFieldsProperties(fieldProperties);
			
			logger.debug("RightSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RightSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RightSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RightSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}