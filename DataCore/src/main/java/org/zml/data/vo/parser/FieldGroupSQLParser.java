package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.Field;
import org.zml.data.vo.bind.FieldGroup;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class FieldGroupSQLParser extends SQLParser implements SQLParserAble
{
	public FieldGroupSQLParser( FieldGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldGroup))
		{
			throw new Exception(" FieldGroupSQLParser only parse FieldGroup");
		}
		result = true;
		return result;
	}
	
	@Override 
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException{
		
		try{
			logger.debug("FieldGroupSQLParser��ʼִ��LoadVODefine��");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties����ڲ���fieldPropertiesΪ�ա�");
			}
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("ǿ��ת���� ����");
			}
			
			if( config.getField() == null ){
				throw new Exception("FieldGroup û������Field");
			}
			
			int mSize = config.getField().size();
			
			if ( mSize == 0 ){
				throw new Exception("FieldGroupû������Field�б�");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				Field field = config.getField().get(ii);
				if( field == null ){
					logger.error("FieldGroup��Field ��ԱΪ�ա�");
					continue;
				}
				
				SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(field);
				if( fieldAble == null ){
					logger.error("FieldGroup��Field��Աû�ж�Ӧ��ParserTools�ࡣ");
					continue;
				}
				
				fieldAble.loadFieldsProperties( fieldProperties );
			}
			
			logger.debug("FieldGroupSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FieldGroupSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				
				logger.error("FieldGroupSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FieldGroupSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	

	
}