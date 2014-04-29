package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.FormSet;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;
public class FormSetSQLParser extends SQLParser implements SQLParserAble
{
	public FormSetSQLParser( FormSet element)
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
		if ( !(this.getQueryDefineElement() instanceof FormSet))
		{
			throw new Exception(" FormSetSQLParser only parse FormSet");
		}
		result = true;
		return result;
	}
	
	@Override
	public CommandForm parserDataSetStringCommand(VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			
			logger.debug("FormSetSQLParser��ʼִ��parserCommand��");	
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FormSet config = (FormSet)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement����ΪSQLSet����" );
			}
			
			if( config.getForm() == null ){
				throw new Exception("SQLSet��������Content������Ϊ���");
			}
			
			SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter( config.getForm() );
			if( formAble == null){
				throw new Exception(" FormSet��Form����SQLParserAble���� ");
			}
			
			CommandForm formCommand = formAble.parserCommand(form);
			if( formCommand == null){
				return result;
			}
			
			if( formCommand.getCommand() == null){
				throw new Exception("FormSet��Form ��ִ��parserCommand����CommandFormʧ�ܡ�");
			}
			
			result = new CommandForm();
			
			result.setAlias(UtilTools.getTrim(config.getAlias()));
			
			CommandConfiguration command = new CommandConfiguration();
			result.setCommand( command );
			//result.setCommand( UtilTools.getTrim( formCommand.getCommand() ) );
			
			logger.debug("FormSetSQLParserִ��parserCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormSetSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FormSetSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormSetSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("FormSetSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("FormSetSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			FormSet config = (FormSet)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement ת����FormSet���� ");
			}
			
			if( config.getForm() == null ){
				logger.error("FormSet û�����ö�Ӧ��form.");
				return;
			}
			
			SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter(config.getForm());
			if( formAble == null ){
				logger.error("FormSet��form û�����ö�Ӧ��SQLParserAble.");
				return;
			}
			formAble.loadSchemas(schema, properties);
			
			logger.debug("FormSetSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormSetSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FormSetSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormSetSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}