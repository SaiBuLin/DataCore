package org.zml.data.vo.parser;

import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.SelectForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class SelectFormSQLParser extends SQLParser implements SQLParserAble
{
	
	public SelectFormSQLParser( SelectForm element)
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
		if ( !(this.getQueryDefineElement() instanceof SelectForm))
		{
			throw new Exception(" SelectFormSQLParser only parse SelectForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("SelectFormSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("SelectFormSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			SelectForm config = (SelectForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("SelectFormSQLParser����loadSchemas, queryDefineElement����ΪSelectForm����" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("SelectForm ��ActionTools ����Ϊ�գ��޷��������ݷ���");
			}
			
			if( config.getFormPart() != null ){
				SQLParserAble formparstAble = SQLParserFactory.getQueryDefineInterpreter(config.getFormPart());
				if( formparstAble != null ){
					formparstAble.loadSchemas(schema, properties);
				}else{
					logger.error("SelectForm ��FormPart����PraserAble ʧ�ܡ�");
				}
			}else{
				logger.error("SelectForm ��FormPartû�����á�");
			}
			
			if( config.getDataSet() != null ){
				SQLParserAble DataSetAble = SQLParserFactory.getQueryDefineInterpreter(config.getDataSet());
				if( DataSetAble != null ){
					DataSetAble.loadSchemas(schema, properties);
				}else{
					logger.error("SelectForm ��DataSet����PraserAble ʧ�ܡ�");
				}
			}else{
				logger.error("SelectForm ��DataSetû�����á�");
			}
		
			logger.debug("SelectFormSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectFormSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("SelectFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		CommandForm result = new CommandForm();		
		try{
			
			logger.debug("SelectFormSQLParser��ʼִ��parserCommand��");	
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			SelectForm config = (SelectForm)this.queryDefineElement;
			
			if( config == null){			
				throw new Exception("SelectFormSQLParser����parserCommand, queryDefineElement����ΪSelectForm����" );
			}
			
			if( config.getFormPart() == null){
				throw new Exception("SelectFormSQLParser����parserCommand, FormPartû�����á�" );
			}
			
			if( config.getDataSet() == null){
				throw new Exception("SelectFormSQLParser����parserCommand, DataSetû�����á�" );
			}
			
			if( config.getActionTools() == null ){
				throw new Exception("SelectFormSQLParser����parserCommand, ActionToolsû�����á�" );
			}
			
			SQLParserAble partAble = SQLParserFactory.getQueryDefineInterpreter(config.getFormPart() );
			
			if( partAble == null){
				throw new Exception("SelectFormSQLParser����parserCommand, FormPart������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			
			SQLParserAble dataSetAble = SQLParserFactory.getQueryDefineInterpreter(config.getDataSet() );
			if( dataSetAble == null){
				throw new Exception("SelectFormSQLParser����parserCommand, DataSet������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			
			CommandForm dataset = dataSetAble.parserDataSetStringCommand(form);
			if( dataset == null ){
				throw new Exception("DataSetû��ָ��������ָ������");
			}
			
			CommandForm selectForm = partAble.parserSelectCommand(
					DATA_MODE_FOR_SELECT,dataset.getAlias(), form);
			
			CommandForm whereForm =  partAble.parserWhereCommand(
					DATA_MODE_FOR_SELECT,dataset.getAlias(), form);
			
			CommandForm orderForm =  partAble.parserOrderCommand(
					DATA_MODE_FOR_SELECT,
					dataset.getAlias(), form);
			
			CommandForm groupbyForm = partAble.parserGroupbyCommand(
					DATA_MODE_FOR_SELECT,
					dataset.getAlias(), form);
			
		
			//if( config.getFormPart() )
			SQLParserAble actionToolsAble = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if( actionToolsAble == null){
				throw new Exception("SelectFormSQLParser����parserCommand, ActionTools������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			
			if( form.getFormActionTools() == null ){
				IActionTools iaction = actionToolsAble.parseFormActionTools();
				form.setFormActionTools(iaction);
			}
			
			/* ����Select��Ӧ������ */
			result = actionToolsAble.parserCommand(
					DATA_MODE_FOR_SELECT,
					form,
					selectForm,
					whereForm,
					orderForm,
					groupbyForm,
					dataset
					);
			
			logger.debug("SelectFormSQLParserִ��parserCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectFormSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("SelectFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		
		return null;
	}

	@Override 
	public void loadFieldsProperties( FieldsConfig fieldProperties) throws DataServiceException{
		try{
			logger.debug("SelectFormSQLParser��ʼִ��loadFieldsProperties��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return;
			}
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties ��ڲ���fieldPropertiesΪ�ա�");
			}
			
			SelectForm config = (SelectForm)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("SelectForm ������formPart û�����á�");
			}
			
			SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( config.getFormPart() );
			if( formpartAble == null ){
				throw new Exception("Select������formPartû�ж�Ӧ��ParserTools�ࡣ");
			}
			
			formpartAble.loadFieldsProperties(fieldProperties);
			
			logger.debug("SelectFormSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectFormSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("SelectFormSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectFormSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	
	@Override
	public NetDataSet executeVOAction(VOForm form, String formcode) throws DataServiceException{
		NetDataSet result = null;
		/* VO Schema  */
		try{
			logger.debug("SelectFormSQLParser ִ��executeVOAction��");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* ǿ��ת�� */
			logger.debug("executeVOAction ִ�У���queryDefineElementǿ��ת����SelectForm.");
			SelectForm config = (SelectForm)this.getQueryDefineElement();
			
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
				logger.error("SelectFormû������ActionTools��");
				return result;
			}
			
			SQLParserAble actionParser = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if(actionParser == null ){
				logger.error("SelectForm ����ActionTools����SQLParserAble����");
				return result;
			}
			
			IActionTools actionTools = actionParser.parseFormActionTools();
			
			if( actionTools == null ){
				logger.error("SelectForm ����ActionTools����SQLParserAbleִ��parseFormActionTools����");
				return result;
			}
			
			IFormActionTools formTools = (IFormActionTools)actionTools ;
			
			IConnectionAble connection = actionParser.parseConnection();
			
			result = formTools.executeQuery(connection, form, formCommand);
			
			logger.debug("SelectFormSQLParser ִ��executeVOAction��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("SelectFormSQLParser::executeVOAction �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("SelectFormSQLParser::executeVOAction �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("SelectFormSQLParser::executeVOAction �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
}