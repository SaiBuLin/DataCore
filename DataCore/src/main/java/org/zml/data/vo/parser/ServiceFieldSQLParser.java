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
			logger.debug("ServiceFieldSQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			if( config == null ){
				throw new Exception("强制转换到 错误。");
			}
			
			if( config.getStatus() != null ){
				SQLParserAble statusAble = SQLParserFactory.getQueryDefineInterpreter(config.getStatus() );
				if( statusAble != null ){
					statusAble.loadSchemas(schema, properties);
				}else{
					logger.error("ServiceField的status 没有能创建对应SQLParserAble.");
				}
			}else{
				logger.error("ServiceField 没有配置Status.");
			}
			
			
			logger.debug("ServiceFieldSQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				
				logger.error("ServiceFieldSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override 
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException{
		
		try{
			logger.debug("ServiceFieldSQLParser开始执行LoadVODefine。");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties的入口参数fieldProperties为空。");
			}
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			if( config == null ){
				throw new Exception("强制转换到 错误。");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			
			if(UtilTools.isNull(code)){
				throw new Exception("ServiceField 必须配置code.");
			}
			
			fieldProperties.put(code, config);
			
			
			logger.debug("ServiceFieldSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				
				logger.error("ServiceFieldSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
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
			logger.debug("ServiceFieldSQLParser开始执行parserSelectCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() )){
				throw new Exception("ServiceField 的属性field 没有配置。");
			}
			
			if( form == null ){
				throw new Exception("入口参数form 没有指定。");
			}
			
			if( form.getQueryRequestService() == null ){
				throw new Exception("入口参数form的QueryRequestService 没有指定。");
			}
			
			if( form.getFormActionTools() == null ){
				throw new Exception("VOForm 的FormActionTools 为空。");
			}
			/* 判断code 对应 是否被选中。 */
			
			String code = UtilTools.getTrim(config.getCode());
			if( UtilTools.isNull(code) ){
				throw new Exception("ServiceField 必须配置code.");
			}
			
			VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
			
			/* 表示没有找到对应的Field */
			if( requestAble.getSelectedField(code) == null ){
				/* 不进行处理。 */
				return null;
			}
			
			IFormActionTools iformAction = (IFormActionTools)form.getFormActionTools();
			
			if( iformAction == null ){
				throw new Exception(" Action 的接口需要IFormActionTools。");
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
				throw new Exception("SQLCommandAble创建错误。");
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
			
			logger.debug("ServiceFieldSQLParser执行parserSelectCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::parserSelectCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceFieldSQLParser::parserSelectCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::parserSelectCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public CommandForm parserWhereCommand(int index, String alias, VOForm form ) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("ServiceFieldSQLParser开始执行parserWhereCommand。");	
			

			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() )){
				throw new Exception("ServiceField 的属性field 没有配置。");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			if( UtilTools.isNull(code) ){
				throw new Exception("ServiceField 必须配置code.");
			}
			
			VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
			
			/* 表示没有找到对应的Field */
			if( requestAble.getSelectedField(code) == null ){
				/* 不进行处理。 */
				return null;
			}
			
			if( form.getFormActionTools() == null ){
				throw new Exception("VOForm 的FormActionTools 为空。");
			}
			
			IFormActionTools iformAction = (IFormActionTools)form.getFormActionTools();
			if( iformAction == null ){
				throw new Exception(" Action 的接口需要IFormActionTools。");
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
				throw new Exception("SQLCommandAble创建错误。");
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
			
			logger.debug("ServiceFieldSQLParser执行parserWhereCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::parserWhereCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceFieldSQLParser::parserWhereCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::parserWhereCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public CommandForm parserOrderCommand( int index,  String alias, VOForm form ) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("ServiceFieldSQLParser开始执行parserSelectCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() )){
				throw new Exception("ServiceField 的属性field 没有配置。");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			if( UtilTools.isNull(code) ){
				throw new Exception("ServiceField 必须配置code.");
			}
			
			VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
			
			/* 表示没有找到对应的Field */
			if( requestAble.getSelectedField(code) == null ){
				/* 不进行处理。 */
				return null;
			}
			
			if( form.getFormActionTools() == null ){
				throw new Exception("VOForm 的FormActionTools 为空。");
			}
			
			IFormActionTools iformAction = (IFormActionTools)form.getFormActionTools();
			if( iformAction == null ){
				throw new Exception(" Action 的接口需要IFormActionTools。");
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
				throw new Exception("SQLCommandAble创建错误。");
			}
			ServiceTask taskRequest = new ServiceTask(); 
			taskRequest.setCode( config.getField() );
			taskRequest.setIndex(0);
			taskRequest.setCommandContent(command);
			sqlCommandAble.addRequestTask( taskRequest );
			
			result.setCommand(  command_param );
			

			result.setAlias(UtilTools.getTrim(alias));
			
			logger.debug("ServiceFieldSQLParser执行parserOrderCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::parserOrderCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceFieldSQLParser::parserOrderCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::parserOrderCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public CommandForm parserGroupbyCommand( int index, String alias, VOForm form ) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("ServiceFieldSQLParser开始执行parserGroupbyCommand。");	
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			ServiceField config = (ServiceField)this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() )){
				throw new Exception("ServiceField 的属性field 没有配置。");
			}
			
			String code = UtilTools.getTrim(config.getCode());
			if( UtilTools.isNull(code) ){
				throw new Exception("ServiceField 必须配置code.");
			}
			
			VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter(form.getQueryRequestService());
			
			/* 表示没有找到对应的Field */
			if( requestAble.getSelectedField(code) == null ){
				/* 不进行处理。 */
				return null;
			}
			
			if( form.getFormActionTools() == null ){
				throw new Exception("VOForm 的FormActionTools 为空。");
			}
			IFormActionTools iformAction = (IFormActionTools)form.getFormActionTools();
			if( iformAction == null ){
				throw new Exception(" Action 的接口需要IFormActionTools。");
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
				throw new Exception("SQLCommandAble创建错误。");
			}
			ServiceTask taskRequest = new ServiceTask(); 
			taskRequest.setCode( config.getField() );
			taskRequest.setIndex(0);
			taskRequest.setCommandContent(command);
			sqlCommandAble.addRequestTask( taskRequest );
			
			result.setCommand( command_param );

			result.setAlias(UtilTools.getTrim(alias));
			
			logger.debug("ServiceFieldSQLParser执行parserGroupbyCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceFieldSQLParser::parserGroupbyCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ServiceFieldSQLParser::parserGroupbyCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceFieldSQLParser::parserGroupbyCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}