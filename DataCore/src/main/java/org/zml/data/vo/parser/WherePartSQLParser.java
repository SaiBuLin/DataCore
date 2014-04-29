package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.service.page.request.parser.VOServiceRequestAble;
import org.zml.data.service.page.request.parser.VOServiceRequestFactory;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.WherePart;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class WherePartSQLParser extends SQLParser implements SQLParserAble
{
	public WherePartSQLParser( WherePart element)
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
		if ( !(this.getQueryDefineElement() instanceof WherePart))
		{
			throw new Exception(" WherePartSQLParser only parse WherePart");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("WherePartSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("WherePartSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			WherePart config = (WherePart)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement ת����WherePart���� ");
			}
			
			if( config.getField() == null ){
				logger.error("WherePart û�����ö�Ӧ��field.");
				return;
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(config.getField());
			if( fieldAble == null ){
				logger.error("WherePart��field û�����ö�Ӧ��SQLParserAble.");
				return;
			}
			fieldAble.loadSchemas(schema, properties);
			
			logger.debug("WherePartSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("WherePartSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("WherePartSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("WherePartSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(FieldsConfig fieldProperties) throws DataServiceException{
		try{
			
			logger.debug("WherePartSQLParser��ʼִ��LoadVODefine��");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties����ڲ���fieldPropertiesΪ�ա�");
			}
			
			WherePart config = (WherePart)this.queryDefineElement;
			if( config == null ){
				throw new Exception("ǿ��ת���� ����");
			}
			
			if( fieldProperties.getWhereFields() == null ){
				fieldProperties.setWhereFields(new HashMap<String,Object>());
			}
			
			if( config.getField() == null ){
				throw new Exception("WherePart û�����ö�ӦField.");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("WherePart ���õ�Field û�ж�Ӧ��ParserTools.");
			}
			
			fieldAble.loadFieldsProperties(fieldProperties.getWhereFields());
			
			
			logger.debug("WherePartSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("WherePartSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				
				logger.error("WherePartSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("WherePartSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	@Override
	public CommandForm parserWhereCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("WherePartSQLParser��ʼִ��parserWhereCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			if( form == null){
				throw new Exception("Where ����������Ҫ����form.");
			}
			
			WherePart config = (WherePart)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("WherePart ������field û�����á�");
			}
			
			SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter( config.getField() );
			if( fieldAble == null){
				throw new Exception("WherePartSQLParser����parserWhereCommand, field������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			
			result  = fieldAble.parserWhereCommand(index, alias, form);
			
			if( result == null){
				throw new Exception("����VOForm ParserWhereCommandʧ�ܡ�");
			}
			
			if(  result.getCommand() == null ){
				throw new Exception("����VOForm ParserWhereCommand,����Command������Ϊ�ա�");
			}
			
			
			
			String WhereString = "";// UtilTools.getTrim( result.getCommand() );
			
			/* �����ַ�','���ֽ� */
			String[] whereFields = splitString( WhereString, ",");
			String command = "";
			if( form.getQueryRequestService() != null ){
				VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
				if( requestAble == null ){
					return result;
				}
				command = requestAble.parseWhereForSyntax(form, alias, whereFields);
			}
			
			result = new CommandForm();
			
			CommandConfiguration commandInfo = new CommandConfiguration();
			//result.setCommand(command);
			
			result.setCommand( commandInfo );
			
			result.setAlias(alias);
			//form.getQueryRequestService()
			
			logger.debug("WherePartSQLParserִ��parserWhereCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("WherePartSQLParser::parserWhereCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("WherePartSQLParser::parserWhereCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("WherePartSQLParser::parserWhereCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
}