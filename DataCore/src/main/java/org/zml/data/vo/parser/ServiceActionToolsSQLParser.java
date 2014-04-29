package org.zml.data.vo.parser;
import java.util.HashMap;

import org.zml.data.vo.bind.ServiceActionTools;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.ServiceTask;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class ServiceActionToolsSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceActionToolsSQLParser( ServiceActionTools element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceActionTools))
		{
			throw new Exception(" ServiceActionToolsSQLParser only parse ServiceActionTools");
		}
		result = true;
		return result;
	}
	
	@Override
	public CommandForm parserCommand(
			int index,
			VOForm form, 
			CommandForm selectForm,
			CommandForm whereForm,
			CommandForm orderForm,
			CommandForm groupbyForm,
			CommandForm dataset) throws DataServiceException{
		
		CommandForm result = null;
		try{
			
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ServiceActionTools config = (ServiceActionTools)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("ServiceActionTools ����ʧ�ܡ�");
			}
			
			if( form == null ){
				throw new Exception("��ڲ���form Ϊ�ա�");
			}
			
			if( dataset == null ){
				throw new Exception("��ڲ���dataset Ϊ�ա�");
			}
			
			if( config.getClassname() == null ){
				throw new Exception(" Action Tools ��Ӧ��className û��ָ���� ");
			}
			
			String tmpClassName = UtilTools.getTrim( config.getClassname() );
			
			Object newActionClass = Class.forName(tmpClassName).newInstance();
			
			if(!( newActionClass instanceof org.zml.data.vo.tools.action.IFormActionTools )){
				throw new Exception("Form ʹ�õ�ActionTools ����ʵ��org.zml.data.vo.tools.action.IFormActionTools�ӿڡ�");
			}
			
			org.zml.data.vo.tools.action.IFormActionTools iActionTools = ( org.zml.data.vo.tools.action.IFormActionTools )newActionClass;
			String commandString = "";
			if( index == DATA_MODE_FOR_SELECT ){
				commandString = iActionTools.getFromQueryString( form, selectForm, whereForm, orderForm, groupbyForm, dataset );
			}
			else if( index == DATA_MODE_FOR_UPDATE ){
				commandString = iActionTools.getFromUpdateString( form, selectForm, whereForm, orderForm, groupbyForm, dataset );
			}
			else if( index == DATA_MODE_FOR_INSERT ){
				commandString = iActionTools.getFromInsertString( form, selectForm, whereForm, orderForm, groupbyForm, dataset );
			}
			else if( index == DATA_MODE_FOR_DELETE ){
				commandString = iActionTools.getFromDeleteString( form, selectForm, whereForm, orderForm, groupbyForm, dataset );
			}
			
			if(UtilTools.isNull(commandString)){
				throw new Exception("������Ϊ��");
			}
			
			CommandConfiguration commandconfig = new CommandConfiguration();
			ServiceTask taskrequest = new ServiceTask();
			taskrequest.setCommandContent(commandString);
			taskrequest.setIndex(0);
			taskrequest.setCode("CODE_INPUT_0");
			
			SQLCommandAble commandAble = SQLCommandFactory.getQueryDefineInterpreter(commandconfig);
			if( commandAble == null ){
				throw new Exception("Command ���ɴ���");
			}
			commandAble.addRequestTask(taskrequest);
			
			
			result = new CommandForm();
			result.setCommand( commandconfig );
			result.setAlias( "" );
			result.setProperties(new HashMap<String,Object>());
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	

	@Override
	public CommandForm parserCommand(
			int index,
			VOForm form, 
			CommandForm relationForm) throws DataServiceException{
		CommandForm result = null;
		try{
			
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override 
	public IActionTools parseFormActionTools() throws DataServiceException{
		IActionTools result = null;
		try{
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ServiceActionTools config = (ServiceActionTools)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("ServiceActionTools ����ʧ�ܡ�");
			}
			String tmpClassName = UtilTools.getTrim( config.getClassname() );
			
			Object newActionClass = Class.forName(tmpClassName).newInstance();
			
			if(!( newActionClass instanceof org.zml.data.vo.tools.action.IFormActionTools )){
				throw new Exception("Form ʹ�õ�ActionTools ����ʵ��org.zml.data.vo.tools.action.IFormActionTools�ӿڡ�");
			}
			
			result = ( org.zml.data.vo.tools.action.IActionTools )newActionClass;
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parserFormActionTools �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parserFormActionTools �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parserFormActionTools �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
			result = null;
		}
		return result;
	}
	

	@Override 
	public IConnectionAble parseConnection() throws DataServiceException{
		IConnectionAble result = null;
		try{
			logger.debug("ServiceActionToolsSQLParser��ʼִ��parseConnection��");	
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ServiceActionTools config = (ServiceActionTools)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("ServiceActionTools ����ʧ�ܡ�");
			}
			
			if( config.getConnection() ==  null){
				throw new Exception("ServiceActionTools û������Connection");
			}
			
			SQLParserAble connectionParser = SQLParserFactory.getQueryDefineInterpreter( config.getConnection() );
			if( connectionParser == null ){
				throw new Exception("Connection ����SQLParserAble ����");
			}
			
			result = connectionParser.parseConnection();
		
			logger.debug("ServiceActionToolsSQLParserִ��parseConnection��ϡ�");	
			
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parseConnection �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parseConnection �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parseConnection �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
}