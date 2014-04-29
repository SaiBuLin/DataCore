package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.bind.OrderPart;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class OrderPartSQLParser extends SQLParser implements SQLParserAble
{
	public OrderPartSQLParser( OrderPart element)
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
		if ( !(this.getQueryDefineElement() instanceof OrderPart))
		{
			throw new Exception(" OrderPartSQLParser only parse OrderPart");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("OrderPartSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("OrderPartSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			OrderPart config = (OrderPart)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement ת����OrderPart���� ");
			}
			
			if( config.getField() == null ){
				logger.error("OrderPart û�����ö�Ӧ��field.");
				return;
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(config.getField());
			if( fieldAble == null ){
				logger.error("OrderPart��field û�����ö�Ӧ��SQLParserAble.");
				return;
			}
			fieldAble.loadSchemas(schema, properties);
			
			logger.debug("OrderPartSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("OrderPartSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("OrderPartSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("OrderPartSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		try{
			
			logger.debug("OrderPartSQLParser��ʼִ��LoadVODefine��");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties����ڲ���fieldPropertiesΪ�ա�");
			}
			
			OrderPart config = (OrderPart)this.queryDefineElement;
			if( config == null ){
				throw new Exception("ǿ��ת���� ����");
			}
			
			if( fieldProperties.getOrderFields() == null ){
				fieldProperties.setOrderFields(new HashMap<String,Object>());
			}
			
			if( config.getField() == null ){
				throw new Exception("OrderPart û�����ö�ӦField.");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("OrderPart ���õ�Field û�ж�Ӧ��ParserTools.");
			}
			
			fieldAble.loadFieldsProperties(fieldProperties.getOrderFields());
			
			
			logger.debug("OrderPartSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("OrderPartSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				
				logger.error("OrderPartSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("OrderPartSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	@Override
	public CommandForm parserOrderCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("OrderPartSQLParser��ʼִ��parserOrderCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			OrderPart config = (OrderPart)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("OrderPart ������field û�����á�");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("parserOrderCommand, field������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			result  = fieldAble.parserOrderCommand(index, alias, form);
			logger.debug("OrderPartSQLParserִ��parserOrderCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("OrderPartSQLParser::parserOrderCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("OrderPartSQLParser::parserOrderCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("OrderPartSQLParser::parserOrderCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
}