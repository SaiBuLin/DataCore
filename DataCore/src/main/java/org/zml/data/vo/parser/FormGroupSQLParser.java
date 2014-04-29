package org.zml.data.vo.parser;
import java.util.HashMap;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.Form;
import org.zml.data.vo.bind.FormGroup;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class FormGroupSQLParser extends SQLParser implements SQLParserAble
{
	public FormGroupSQLParser( FormGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FormGroup))
		{
			throw new Exception(" FormGroupSQLParser only parse FormGroup");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("FormGroupSQLParser执行loadSchemas");
			if( this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null ){
				throw new Exception("FormGroupSQLParser错误：loadSchemas入口参数schema为空。" );
			}
			
			
			FormGroup config = (FormGroup)this.queryDefineElement;
			
			if( config == null){
				throw new Exception("FormGroupSQLParser错误：loadSchemas, queryDefineElement构型为FormGroup错误。" );
			}
			
			if( config.getForm() == null ){
				throw new Exception("FormGroupSQLParser错误：loadSchemas, queryDefineElement构型为FormGroup错误。" );
			}
			
			int mSize = config.getForm().size();
			
			if( mSize == 0 ){
				logger.error("FormGroupSQLParser错误：loadSchemas, 在XML中改VO 没有配置Form列表。" );
				throw new Exception("FormGroupSQLParser错误：loadSchemas, queryDefineElement构型为FormGroup错误。" );
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				Form form = config.getForm().get(ii);
				SQLParserAble iable = SQLParserFactory.getQueryDefineInterpreter( form );
				
				if( iable == null )continue;
				logger.debug("FormGroupSQLParser错误：loadSchemas, 装载Form。" );
				iable.loadSchemas( schema, properties);
			}
			
			
			logger.debug("FormGroupSQLParser的LoadVODefine执行完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormGroupSQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormGroupSQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormGroupSQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	
	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		/* From Group 形成多个configuration */
		CommandForm result = null;
		try{
			logger.debug("FormGroupSQLParser开始执行parserCommand。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			FormGroup config = (FormGroup)this.queryDefineElement;
			if( config == null){			
				throw new Exception("FormGroupSQLParser错误：parserCommand, queryDefineElement构型为FormGroup错误。" );
			}
			
			if( config.getForm() == null ){
				throw new Exception("FormGroupSQLParser 没有配置Form.");
			}
			
			int mSize = config.getForm().size();
			
			if( mSize == 0 ){
				throw new Exception("FormGroupSQLParser 没有配置Form.");
			}
			CommandConfiguration command = new CommandConfiguration();
			result = new CommandForm();
			
			SQLCommandAble commable = SQLCommandFactory.getQueryDefineInterpreter(command);
			//StringBuffer sBuf = new StringBuffer();
			
			result.setProperties(new HashMap<String,Object>());
			/* TaskRequest 记录多个SQL 文 */
			for( int ii = 0; ii < mSize; ii++ ){
				Form myform = config.getForm().get(ii);
				
				SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter( myform );
				if( formAble == null ){
					logger.error("FormGroupSQLParser的Form属性没有对应的ParserTools. ");
					continue;
				}
				
				CommandForm cmmd = formAble.parserCommand(form);
				if( cmmd == null )continue;
				
				/* 命令进行叠加 */
				if( commable != null ){
					commable.addRequestTask( cmmd.getCommand() );
				}
				
				//sBuf.append("<DataCommand>");
				//sBuf.append( cmmd.getCommand() );
				//sBuf.append("</DataCommand>");
				/* Property 如果想用的Key 就可能相互覆盖 */
				if( cmmd.getProperties() != null ){
					result.getProperties().putAll(cmmd.getProperties());
				}
			}
			
			//result.setCommand(sBuf.toString());
			/* 返回Property */
			result.setCommand( command );
			
			logger.debug("FormGroupSQLParser执行parserCommand完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormGroupSQLParser::loadVODefine 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormGroupSQLParser::loadVODefine 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormGroupSQLParser::loadVODefine 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException{
		NetDataSet result = null;
		try{
			logger.debug("FormGroupSQLParser开始执行executeVOAction。");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			FormGroup config = (FormGroup)this.queryDefineElement;
			if( config == null){			
				throw new Exception("FormGroupSQLParser错误：executeVOAction, queryDefineElement构型为FormGroup错误。" );
			}
			
			if( config.getForm() == null ){
				throw new Exception("FormGroupSQLParser 没有配置Form.");
			}
			
			int mSize = config.getForm().size();
			
			if( mSize == 0 ){
				throw new Exception("FormGroupSQLParser 没有配置Form.");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				Form myform = config.getForm().get(ii);
				
				SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter( myform );
				if( formAble == null ){
					logger.error("FormGroupSQLParser的Form属性没有对应的ParserTools. ");
					continue;
				}
				
				result = formAble.executeVOAction(form, formcode);
				if( result != null ){
					break;
				}
			}
			
			logger.debug("FormGroupSQLParser执行executeVOAction完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormGroupSQLParser::executeVOAction 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormGroupSQLParser::executeVOAction 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormGroupSQLParser::executeVOAction 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
}