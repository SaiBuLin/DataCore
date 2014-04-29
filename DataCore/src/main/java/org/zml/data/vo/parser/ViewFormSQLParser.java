package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.ViewForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class ViewFormSQLParser extends SQLParser implements SQLParserAble
{
	public ViewFormSQLParser( ViewForm element)
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
		if ( !(this.getQueryDefineElement() instanceof ViewForm))
		{
			throw new Exception(" ViewFormSQLParser only parse ViewForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("ViewFormSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("ViewFormSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			ViewForm config = (ViewForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("ViewFormSQLParser����loadSchemas, queryDefineElement����ΪViewForm����" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("ViewFormSQLParser ��ActionTools ����Ϊ�գ��޷��������ݷ���");
			}
		
			if( config.getLeft() != null ){
				SQLParserAble leftarstAble = SQLParserFactory.getQueryDefineInterpreter(  config.getLeft()  );
				if( leftarstAble != null ){
					leftarstAble.loadSchemas(schema, properties);
				}else{
					logger.error("ViewForm ��Left����PraserAble ʧ�ܡ�");
				}
			}else{
				logger.error("ViewForm ��Leftû�����á�");
			}
			
			if( config.getRight() != null ){
				SQLParserAble leftarstAble = SQLParserFactory.getQueryDefineInterpreter(  config.getRight()  );
				if( leftarstAble != null ){
					leftarstAble.loadSchemas(schema, properties);
				}else{
					logger.error("ViewForm ��right����PraserAble ʧ�ܡ�");
				}
			}else{
				logger.error("ViewForm ��rightû�����á�");
			}
			
			logger.debug("ViewFormSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ViewFormSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ViewFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ViewFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		/* VIEW FORM��ֻ֧�֣ӣѣ̡��ģµ����ݷ��� */
		CommandForm result = null;
		try{
			logger.debug("ViewFormSQLParser��ʼִ��parserCommand��");
			
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ViewForm config = (ViewForm)this.queryDefineElement;
			if( config == null){			
				throw new DataServiceException("ViewFormSQLParser����parserCommand, queryDefineElement����ΪViewForm����" );
			}
		
			
			if( (config.getLeft() == null)
					&& ( config.getRight() == null )
					){
				throw new DataServiceException("ViewForm ���õ�Left��Right ��Ϊ�ա�");
			}
			else if ( config.getRight() == null ){
				SQLParserAble leftAble = SQLParserFactory.getQueryDefineInterpreter(config.getLeft() ) ;
				
				if( leftAble == null ){
					throw new DataServiceException("ViewFormSQLParser����parserCommand, Left���Բ��ܶ�ӦParserTools." ); 
				}
				logger.debug("ActionTools ����View ��������" );
				result = leftAble.parserCommand(form);
			}
			else if ( config.getLeft() == null ){
				SQLParserAble rightAble = SQLParserFactory.getQueryDefineInterpreter(config.getRight() ) ;
				
				if( rightAble == null ){
					throw new DataServiceException("ViewFormSQLParser����parserCommand, Right���Բ��ܶ�ӦParserTools." ); 
				}
				logger.debug("ActionTools ����View ��������" );
				result = rightAble.parserCommand(form);
			}else {
				/* װ��FieldProperties */
				FieldsConfig fieldProperties = new FieldsConfig();
				
				this.loadFieldsProperties(fieldProperties);
				
				form.getProperties().put(PROPERTY_KEY_FIELDS, fieldProperties);
				
				SQLParserAble leftAble = SQLParserFactory.getQueryDefineInterpreter(config.getLeft() ) ;
				
				if( leftAble == null ){
					throw new DataServiceException("ViewFormSQLParser����parserCommand, Left���Բ��ܶ�ӦParserTools." ); 
				}
				
				SQLParserAble rightAble = SQLParserFactory.getQueryDefineInterpreter(config.getRight() ) ;
				
				if( rightAble == null ){
					throw new DataServiceException("ViewFormSQLParser����parserCommand, Right���Բ��ܶ�ӦParserTools." ); 
				}
				
				CommandForm leftForm = leftAble.parserCommand(form);
				
				CommandForm rightForm = rightAble.parserCommand(form);
				
				if( config.getRelation() == null ){
					throw new DataServiceException("ViewFormû������Relation." );
				}
				
				SQLParserAble relationAble = SQLParserFactory.getQueryDefineInterpreter( config.getRelation() ) ;
				
				if( relationAble == null ){
					throw new DataServiceException("ViewFormû������RelationShipû�ж�Ӧ��ParserTools." );
				}
				
				logger.debug("Relation ����View ��������" );
				CommandForm realationForm = relationAble.parserCommand(
						form, 
						leftForm, rightForm, 
						config.getTableRelation() 
						);
				

				if( config.getActionTools() == null ){
					throw new DataServiceException("ViewFormû������ActionTools." );
				}	
				
				logger.debug("����acionToolsAble ����Command." );
				SQLParserAble actionToolsAble = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() ) ;
				
				if( actionToolsAble == null ){
					throw new DataServiceException("ViewFormû������ActionToolsû�ж�Ӧ��ParserTools." );
				}

				if( form.getFormActionTools() == null ){
					IActionTools iaction = actionToolsAble.parseFormActionTools();
					form.setFormActionTools(iaction);
				}
				result = actionToolsAble.parserCommand(
						DATA_MODE_FOR_SELECT,
						form, 
						realationForm);
				
				if( form.getProperties().containsKey(PROPERTY_KEY_FIELDS)){
					form.getProperties().remove(PROPERTY_KEY_FIELDS );
				}
				
			}
			logger.debug("ActionTools ����View �����ֵ����ݣ�" + result.getCommand() );
			logger.debug("ViewFormSQLParserִ��parserCommand��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ViewFormSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ViewFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ViewFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override 
	public void loadFieldsProperties( FieldsConfig fieldProperties) throws DataServiceException{
		try{
			logger.debug("ViewFormSQLParser��ʼִ��loadFieldsProperties��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return;
			}
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties ��ڲ���fieldPropertiesΪ�ա�");
			}
			
			ViewForm config = (ViewForm)this.queryDefineElement;
			
			if( config.getLeft() == null ){
				throw new Exception("SelectForm ������left û�����á�");
			}
			
			SQLParserAble leftAble = SQLParserFactory.getQueryDefineInterpreter( config.getLeft() );
			if( leftAble == null ){
				throw new Exception("Select������leftû�ж�Ӧ��ParserTools�ࡣ");
			}
			
			if( config.getRight() == null ){
				throw new Exception("SelectForm ������right û�����á�");
			}
			
			SQLParserAble rightAble = SQLParserFactory.getQueryDefineInterpreter( config.getRight() );
			if( rightAble == null ){
				throw new Exception("Select������rightû�ж�Ӧ��ParserTools�ࡣ");
			}
			
			leftAble.loadFieldsProperties(fieldProperties);
			
			rightAble.loadFieldsProperties(fieldProperties);
			
			logger.debug("ViewFormSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ViewFormSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ViewFormSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ViewFormSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	@Override
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException{
		NetDataSet result = null;
		/* VO Schema  */
		try{
			logger.debug("ViewFormSQLParser ִ��executeVOAction��");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* ǿ��ת�� */
			logger.debug("executeVOAction ִ�У���queryDefineElementǿ��ת����ViewForm.");
			ViewForm config = (ViewForm)this.getQueryDefineElement();
			
			if( config == null ){
				return result;
			}
			
			if(UtilTools.isNull( config.getCode() )){
				logger.error("ViewForm��Code û�����á�");
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
			
			logger.debug("ִ��VO��Form����Form�ı��Ϊ��" + tmpFormCode );
			
			/* ����������SQL �� */
			CommandForm formCommand = this.parserCommand(form);
			
			if( formCommand == null ){
				logger.error("����CommandForm����");
				return result;
			}
			
			if( config.getActionTools() == null ){
				logger.error("ViewFormû������ActionTools��");
				return result;
			}
			
			SQLParserAble actionParser = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if(actionParser == null ){
				logger.error("ViewForm����ActionTools����SQLParserAble����");
				return result;
			}
			
			IActionTools actionTools = actionParser.parseFormActionTools();
			
			if( actionTools == null ){
				logger.error("ViewForm����ActionTools����SQLParserAbleִ��parseFormActionTools����");
				return result;
			}
			
			IFormActionTools formTools = (IFormActionTools)actionTools ;
			
			IConnectionAble connection = actionParser.parseConnection();
			
			result = formTools.executeQuery(connection, form, formCommand);
			
			logger.debug("ViewFormSQLParserִ��executeVOAction��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ViewFormSQLParser::executeVOAction �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ViewFormSQLParser::executeVOAction �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ViewFormSQLParser::executeVOAction �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
}