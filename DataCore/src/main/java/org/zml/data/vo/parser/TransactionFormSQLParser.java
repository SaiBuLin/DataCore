package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.TransactionForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class TransactionFormSQLParser extends SQLParser implements SQLParserAble
{
	public TransactionFormSQLParser( TransactionForm element)
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
		if ( !(this.getQueryDefineElement() instanceof TransactionForm))
		{
			throw new Exception(" TransactionFormSQLParser only parse TransactionForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("TransactionFormSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("TransactionFormSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			TransactionForm config = (TransactionForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("TransactionFormSQLParser����loadSchemas, queryDefineElement����ΪTransactionForm����" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("TransactionFormSQLParser ��ActionTools ����Ϊ�գ��޷��������ݷ���");
			}
		
			if( config.getForm() != null ){
				SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter(  config.getForm()  );
				if( formAble != null ){
					formAble.loadSchemas(schema, properties);
				}else{
					logger.error("TransactionForm ��form����PraserAble ʧ�ܡ�");
				}
			}else{
				logger.error("TransactionForm ��formû�����á�");
			}
			
			logger.debug("TransactionFormSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("TransactionFormSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("TransactionFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("TransactionFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("TransactionFormSQLParser��ʼִ��parserCommand��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			TransactionForm config = (TransactionForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("TransactionFormSQLParser����parserCommand, queryDefineElement����ΪTransactionForm����" );
			}
			
			if( config.getForm() == null ){
				throw new Exception("TransactionForm û������Form.");
			}
			
			SQLParserAble formAble = SQLParserFactory.getQueryDefineInterpreter( config.getForm() );
			if( formAble == null ){
				throw new Exception("TransactionForm��Form����û�ж�Ӧ��ParserTools. ");
			}
			
			result = formAble.parserCommand(form);
			
			logger.debug("TransactionFormSQLParserִ��parserCommand��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("TransactionFormSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("TransactionFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("TransactionFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}

	@Override
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException{
		NetDataSet result = null;
		/* VO Schema  */
		try{
			logger.debug("TransactionFormSQLParser ִ��executeVOAction��");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* ǿ��ת�� */
			logger.debug("executeVOAction ִ�У���queryDefineElementǿ��ת����TransactionForm.");
			TransactionForm config = (TransactionForm)this.getQueryDefineElement();
			
			if( config == null ){
				return result;
			}
			
			if(UtilTools.isNull( config.getCode() )){
				logger.error("SelectForm��Code û�����á�");
				return result;
			}
			
			if( UtilTools.isNull(formcode) ){
				logger.error("��ڲ���FormCode û��ָ����");
				return result;
			}
			
			String tmpCode = UtilTools.getTrim( config.getCode() );
			
			String tmpFormCode = UtilTools.getTrim( formcode );
			
			if( !tmpFormCode.equalsIgnoreCase(tmpCode) ){
				return result;
			}
			
			logger.debug("ִ��VO ��Form ����Form�ı��Ϊ��" + tmpFormCode );
			
			/* ����������SQL �� */
			CommandForm formCommand = this.parserCommand(form);
			
			if( formCommand == null ){
				logger.error("����CommandForm����");
				return result;
			}
			
			if( config.getActionTools() == null ){
				logger.error("TransactionFormû������ActionTools��");
				return result;
			}
			
			SQLParserAble actionParser = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if(actionParser == null ){
				logger.error("TransactionForm����ActionTools����SQLParserAble����");
				return result;
			}
			
			IActionTools actionTools = actionParser.parseFormActionTools();
			
			if( actionTools == null ){
				logger.error("TransactionForm����ActionTools����SQLParserAbleִ��parseFormActionTools����");
				return result;
			}
			
			IFormActionTools formTools = (IFormActionTools)actionTools ;
			
			IConnectionAble connection = actionParser.parseConnection();
			
			result = formTools.executeQuery(connection, form, formCommand);
			
			logger.debug("TransactionFormSQLParser ִ��executeVOAction��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("TransactionFormSQLParser::executeVOAction �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("TransactionFormSQLParser::executeVOAction �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("TransactionFormSQLParser::executeVOAction �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
}