package org.zml.data.vo.parser;
import java.util.Map;


import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.ServiceField;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.ServiceTask;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;
import org.zml.data.vo.tools.action.IFormActionTools;
          
public class ServiceFieldSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceFieldSQLParser( ServiceField element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceField))
		{
			throw new Exception(" ServiceFieldSQLParser only parse ServiceField");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("ServiceFieldSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			if( config == null ){
				throw new Exception("ǿ��ת���� ����");
			}
			
			if( config.getStatus() != null ){
				SQLParserAble statusAble = SQLParserFactory.getQueryDefineInterpreter(config.getStatus() );
				if( statusAble != null ){
					statusAble.loadSchemas(schema, properties);
				}else{
					logger.error("ServiceField��status û���ܴ�����ӦSQLParserAble.");
				}
			}else{
				logger.error("ServiceField û������Status.");
			}
			
			
			logger.debug("ServiceFieldSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				
				logger.error("ServiceFieldSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException{
		
		try{
			logger.debug("ServiceFieldSQLParser��ʼִ��LoadVODefine��");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties����ڲ���fieldPropertiesΪ�ա�");
			}
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			if( config == null ){
				throw new Exception("ǿ��ת���� ����");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			
			if(UtilTools.isNull(code)){
				throw new Exception("ServiceField ��������code.");
			}
			
			fieldProperties.put(code, config);
			
			
			logger.debug("ServiceFieldSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				
				logger.error("ServiceFieldSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override
	public CommandForm parserSelectCommand(int index, 
			String alias, 
			VOForm form ) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("ServiceFieldSQLParser��ʼִ��parserSelectCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() )){
				throw new Exception("ServiceField ������field û�����á�");
			}
			
			if( form == null ){
				throw new Exception("��ڲ���form û��ָ����");
			}
			
			if( form.getQueryRequestService() == null ){
				throw new Exception("��ڲ���form��QueryRequestService û��ָ����");
			}
			
			if( form.getFormActionTools() == null ){
				throw new Exception("VOForm ��FormActionTools Ϊ�ա�");
			}
			/* �ж�code ��Ӧ �Ƿ�ѡ�С� */
			
			String code = UtilTools.getTrim(config.getCode());
			if( UtilTools.isNull(code) ){
				throw new Exception("ServiceField ��������code.");
			}
			
			VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
			
			/* ��ʾû���ҵ���Ӧ��Field */
			if( requestAble.getSelectedField(code) == null ){
				/* �����д��� */
				return null;
			}
			
			IFormActionTools iformAction = (IFormActionTools)form.getFormActionTools();
			
			if( iformAction == null ){
				throw new Exception(" Action �Ľӿ���ҪIFormActionTools��");
			}
			
			result = new CommandForm();
			
			String command = "";
			if( index == DATA_MODE_FOR_SELECT){				
				command = iformAction.parseSelectFieldForQuery(
						alias, 
						config.getField(),
						code);				
			}else if( index == DATA_MODE_FOR_INSERT){				
				command = iformAction.parseSelectFieldForInsert(
						alias, 
						config.getField(),
						code);
			}else if( index == DATA_MODE_FOR_UPDATE){				
				command = iformAction.parseSelectFieldForUpdate(
						alias, 
						config.getField(),
						code);
			}else if( index == DATA_MODE_FOR_DELETE){				
				command = iformAction.parseSelectFieldForDelete(
						alias, 
						config.getField(),
						code);
			}
			CommandConfiguration command_param = new CommandConfiguration();
			SQLCommandAble sqlCommandAble = SQLCommandFactory.getQueryDefineInterpreter( command_param );
			if( sqlCommandAble == null ){
				throw new Exception("SQLCommandAble��������");
			}
			ServiceTask taskRequest = new ServiceTask(); 
			taskRequest.setCode( config.getField() );
			taskRequest.setIndex(0);
			taskRequest.setCommandContent(command);
			sqlCommandAble.addRequestTask( taskRequest );
			
			//sqlCommandAble.addRequestTask( fieldCommand.getCommand().getRequestTask() );			
			
			
//			
//			StringBuffer sBuf = new StringBuffer();
//			if( !UtilTools.isNull(alias) ){
//				sBuf.append(UtilTools.getTrim(alias));
//				sBuf.append(".");
//			}
//			sBuf.append(UtilTools.getTrim( config.getField()));
//			sBuf.append(" AS ");
//			sBuf.append( code );
//			sBuf.append("  ");
//			
//			result.setCommand( sBuf.toString());
			
			result.setCommand(command_param);
			result.setAlias(UtilTools.getTrim(alias));
			
			logger.debug("ServiceFieldSQLParserִ��parserSelectCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::parserSelectCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceFieldSQLParser::parserSelectCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::parserSelectCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public CommandForm parserWhereCommand(int index, String alias, VOForm form ) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("ServiceFieldSQLParser��ʼִ��parserWhereCommand��");	
			

			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() )){
				throw new Exception("ServiceField ������field û�����á�");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			if( UtilTools.isNull(code) ){
				throw new Exception("ServiceField ��������code.");
			}
			
			VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
			
			/* ��ʾû���ҵ���Ӧ��Field */
			if( requestAble.getSelectedField(code) == null ){
				/* �����д��� */
				return null;
			}
			
			if( form.getFormActionTools() == null ){
				throw new Exception("VOForm ��FormActionTools Ϊ�ա�");
			}
			
			IFormActionTools iformAction = (IFormActionTools)form.getFormActionTools();
			if( iformAction == null ){
				throw new Exception(" Action �Ľӿ���ҪIFormActionTools��");
			}
			
			result = new CommandForm();
			
			String command = "";
			if( index == DATA_MODE_FOR_SELECT){				
				command = iformAction.parseWhereFieldForQuery(
						alias, 
						config.getField(),
						code);				
				
			}else if( index == DATA_MODE_FOR_INSERT){
				
				command = iformAction.parseWhereFieldForInsert(
						alias, 
						config.getField(),
						code);
			}else if( index == DATA_MODE_FOR_UPDATE){				
				command = iformAction.parseWhereFieldForUpdate(
						alias, 
						config.getField(),
						code);
			}else if( index == DATA_MODE_FOR_DELETE){
				
				command = iformAction.parseWhereFieldForDelete(
						alias, 
						config.getField(),
						code);
			}
			
			CommandConfiguration command_param = new CommandConfiguration();
			SQLCommandAble sqlCommandAble = SQLCommandFactory.getQueryDefineInterpreter( command_param );
			if( sqlCommandAble == null ){
				throw new Exception("SQLCommandAble��������");
			}
			ServiceTask taskRequest = new ServiceTask(); 
			taskRequest.setCode( config.getField() );
			taskRequest.setIndex(0);
			taskRequest.setCommandContent(command);
			sqlCommandAble.addRequestTask( taskRequest );
			
			
//			StringBuffer sBuf = new StringBuffer();
//			if( !UtilTools.isNull(alias) ){
//				sBuf.append(UtilTools.getTrim(alias));
//				sBuf.append(".");
//			}
//			sBuf.append(UtilTools.getTrim( config.getField()));
//			sBuf.append(" = ");
//			sBuf.append( "?" );
//			
//			result.setCommand( sBuf.toString());
			result.setCommand( command_param );
			result.setAlias(UtilTools.getTrim(alias));
			
			logger.debug("ServiceFieldSQLParserִ��parserWhereCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::parserWhereCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceFieldSQLParser::parserWhereCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::parserWhereCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public CommandForm parserOrderCommand( int index,  String alias, VOForm form ) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("ServiceFieldSQLParser��ʼִ��parserSelectCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() )){
				throw new Exception("ServiceField ������field û�����á�");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			if( UtilTools.isNull(code) ){
				throw new Exception("ServiceField ��������code.");
			}
			
			VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
			
			/* ��ʾû���ҵ���Ӧ��Field */
			if( requestAble.getSelectedField(code) == null ){
				/* �����д��� */
				return null;
			}
			
			if( form.getFormActionTools() == null ){
				throw new Exception("VOForm ��FormActionTools Ϊ�ա�");
			}
			
			IFormActionTools iformAction = (IFormActionTools)form.getFormActionTools();
			if( iformAction == null ){
				throw new Exception(" Action �Ľӿ���ҪIFormActionTools��");
			}
			
			result = new CommandForm();
			
			String command = "";
			if( index == DATA_MODE_FOR_SELECT){				
				command = iformAction.parseOrderFieldForQuery(
						alias, 
						config.getField(),
						"" );					
			}
			
			CommandConfiguration command_param = new CommandConfiguration();
			SQLCommandAble sqlCommandAble = SQLCommandFactory.getQueryDefineInterpreter( command_param );
			if( sqlCommandAble == null ){
				throw new Exception("SQLCommandAble��������");
			}
			ServiceTask taskRequest = new ServiceTask(); 
			taskRequest.setCode( config.getField() );
			taskRequest.setIndex(0);
			taskRequest.setCommandContent(command);
			sqlCommandAble.addRequestTask( taskRequest );
			
			result.setCommand(  command_param );
			

			result.setAlias(UtilTools.getTrim(alias));
			
			logger.debug("ServiceFieldSQLParserִ��parserOrderCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::parserOrderCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceFieldSQLParser::parserOrderCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::parserOrderCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public CommandForm parserGroupbyCommand( int index, String alias, VOForm form ) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("ServiceFieldSQLParser��ʼִ��parserGroupbyCommand��");	
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() )){
				throw new Exception("ServiceField ������field û�����á�");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			if( UtilTools.isNull(code) ){
				throw new Exception("ServiceField ��������code.");
			}
			
			VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
			
			/* ��ʾû���ҵ���Ӧ��Field */
			if( requestAble.getSelectedField(code) == null ){
				/* �����д��� */
				return null;
			}
			
			if( form.getFormActionTools() == null ){
				throw new Exception("VOForm ��FormActionTools Ϊ�ա�");
			}
			IFormActionTools iformAction = (IFormActionTools)form.getFormActionTools();
			if( iformAction == null ){
				throw new Exception(" Action �Ľӿ���ҪIFormActionTools��");
			}
			
			result = new CommandForm();
			
			String command = "";
			if( index == DATA_MODE_FOR_SELECT){				
				command = iformAction.parseGroupbyFieldForQuery(
						alias, 
						config.getField(),
						"" );				
				
			}
			
			CommandConfiguration command_param = new CommandConfiguration();
			SQLCommandAble sqlCommandAble = SQLCommandFactory.getQueryDefineInterpreter( command_param );
			if( sqlCommandAble == null ){
				throw new Exception("SQLCommandAble��������");
			}
			ServiceTask taskRequest = new ServiceTask(); 
			taskRequest.setCode( config.getField() );
			taskRequest.setIndex(0);
			taskRequest.setCommandContent(command);
			sqlCommandAble.addRequestTask( taskRequest );
			
			result.setCommand( command_param );

			result.setAlias(UtilTools.getTrim(alias));
			
			logger.debug("ServiceFieldSQLParserִ��parserGroupbyCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::parserGroupbyCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceFieldSQLParser::parserGroupbyCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::parserGroupbyCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
}