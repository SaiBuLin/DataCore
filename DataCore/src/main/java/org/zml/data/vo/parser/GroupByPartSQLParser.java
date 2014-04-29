package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.bind.GroupByPart;
import org.zml.data.vo.bind.OrderPart;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class GroupByPartSQLParser extends SQLParser implements SQLParserAble
{
	public GroupByPartSQLParser( GroupByPart element)
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
		if ( !(this.getQueryDefineElement() instanceof GroupByPart))
		{
			throw new Exception(" GroupByPartSQLParser only parse GroupByPart");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("GroupByPartSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("GroupByPartSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			GroupByPart config = (GroupByPart)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement ת����GroupByPart���� ");
			}
			
			if( config.getField() == null ){
				logger.error("GroupByPart û�����ö�Ӧ��field.");
				return;
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(config.getField());
			if( fieldAble == null ){
				logger.error("GroupByPart��field û�����ö�Ӧ��SQLParserAble.");
				return;
			}
			fieldAble.loadSchemas(schema, properties);
			
			logger.debug("GroupByPartSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("GroupByPartSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("GroupByPartSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("GroupByPartSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		try{
			
			logger.debug("GroupByPartSQLParser��ʼִ��LoadVODefine��");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties����ڲ���fieldPropertiesΪ�ա�");
			}
			
			GroupByPart config = (GroupByPart)this.queryDefineElement;
			if( config == null ){
				throw new Exception("ǿ��ת���� ����");
			}
			
			if( fieldProperties.getGroupbyFields() == null ){
				fieldProperties.setGroupbyFields(new HashMap<String,Object>());
			}
			
			if( config.getField() == null ){
				throw new Exception("GroupByPart û�����ö�ӦField.");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("GroupByPart ���õ�Field û�ж�Ӧ��ParserTools.");
			}
			
			fieldAble.loadFieldsProperties(fieldProperties.getGroupbyFields());
			
			
			logger.debug("GroupByPartSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("GroupByPartSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				
				logger.error("GroupByPartSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("GroupByPartSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	@Override
	public CommandForm parserGroupbyCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("GroupByPartSQLParser��ʼִ��parserGroupbyCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			OrderPart config = (OrderPart)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("OrderPart ������field û�����á�");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("parserGroupbyCommand, field������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			result  = fieldAble.parserGroupbyCommand(index, alias, form);
			logger.debug("GroupByPartSQLParserִ��parserGroupbyCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("GroupByPartSQLParser::parserGroupbyCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("GroupByPartSQLParser::parserGroupbyCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("GroupByPartSQLParser::parserGroupbyCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
}

