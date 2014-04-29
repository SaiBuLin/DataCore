package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SelectedPart;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class SelectedPartSQLParser extends SQLParser implements SQLParserAble
{
	public SelectedPartSQLParser( SelectedPart element)
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
		if ( !(this.getQueryDefineElement() instanceof SelectedPart))
		{
			throw new Exception(" SelectedPartSQLParser only parse SelectedPart");
		}
		result = true;
		return result;
	}
	
	@Override
	public CommandForm parserSelectCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("SelectedPartSQLParser��ʼִ��parserSelectCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			SelectedPart config = (SelectedPart)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("SelectedPart ������field û�����á�");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("SelectedPartSQLParser����parserSelectCommand, field������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			result  = fieldAble.parserSelectCommand(index, alias, form);
			logger.debug("SelectedPartSQLParserִ��parserSelectCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectedPartSQLParser::parserSelectCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("SelectedPartSQLParser::parserSelectCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectedPartSQLParser::parserSelectCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("SelectedPartSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("SelectedPartSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			SelectedPart config = (SelectedPart)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement ת����SelectedPart���� ");
			}
			
			if( config.getField() == null ){
				logger.error("SelectedPart û�����ö�Ӧ��field.");
				return;
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(config.getField());
			if( fieldAble == null ){
				logger.error("SelectedPart��field û�����ö�Ӧ��SQLParserAble.");
				return;
			}
			fieldAble.loadSchemas(schema, properties);
			
			logger.debug("SelectedPartSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectedPartSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("SelectedPartSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectedPartSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		try{
			
			logger.debug("SelectedPartSQLParser��ʼִ��LoadVODefine��");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties����ڲ���fieldPropertiesΪ�ա�");
			}
			
			SelectedPart config = (SelectedPart)this.queryDefineElement;
			if( config == null ){
				throw new Exception("ǿ��ת���� ����");
			}
			
			if( fieldProperties.getSelectFields() == null ){
				fieldProperties.setSelectFields(new HashMap<String,Object>());
			}
			
			if( config.getField() == null ){
				throw new Exception("SelectPart û�����ö�ӦField.");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("SelectPart ���õ�Field û�ж�Ӧ��ParserTools.");
			}
			
			fieldAble.loadFieldsProperties(fieldProperties.getSelectFields());
			
			
			logger.debug("SelectedPartSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectedPartSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				
				logger.error("SelectedPartSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectedPartSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}