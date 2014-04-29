package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.DataForm;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.UpdateForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class UpdateFormSQLParser extends SQLParser implements SQLParserAble
{
	public UpdateFormSQLParser( UpdateForm element)
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
		if ( !(this.getQueryDefineElement() instanceof UpdateForm))
		{
			throw new Exception(" UpdateFormSQLParser only parse UpdateForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("UpdateFormSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("UpdateFormSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			UpdateForm config = (UpdateForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("UpdateFormSQLParser����loadSchemas, queryDefineElement����ΪUpdateForm����" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("UpdateFormSQLParser ��ActionTools ����Ϊ�գ��޷��������ݷ���");
			}
			
			if( config.getFormPart() != null ){
				SQLParserAble formparstAble = SQLParserFactory.getQueryDefineInterpreter(config.getFormPart());
				if( formparstAble != null ){
					formparstAble.loadSchemas(schema, properties);
				}else{
					logger.error("UpdateForm ��FormPart����PraserAble ʧ�ܡ�");
				}
			}else{
				logger.error("UpdateForm ��FormPartû�����á�");
			}
			
			if( config.getDataSet() != null ){
				SQLParserAble DataSetAble = SQLParserFactory.getQueryDefineInterpreter(config.getDataSet());
				if( DataSetAble != null ){
					DataSetAble.loadSchemas(schema, properties);
				}else{
					logger.error("UpdateForm ��DataSet����PraserAble ʧ�ܡ�");
				}
			}else{
				logger.error("UpdateForm ��DataSetû�����á�");
			}
		
			logger.debug("UpdateFormSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("UpdateFormSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("InsertFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("InsertFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		CommandForm result = new CommandForm();		
		try{
			
			logger.debug("UpdateFormSQLParser��ʼִ��parserCommand��");	
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* �ж��Ƿ�DataForm */
			if(!( this.queryDefineElement instanceof DataForm ) ){
				return result;
			}
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			
			if( config == null){			
				throw new Exception("UpdateFormSQLParser����parserCommand, queryDefineElement����ΪSelectForm����" );
			}
			
			if( config.getFormPart() == null){
				throw new Exception("UpdateFormSQLParser����parserCommand, FormPartû�����á�" );
			}
			
			if( config.getDataSet() == null){
				throw new Exception("UpdateFormSQLParser����parserCommand, DataSetû�����á�" );
			}
			
			if( config.getActionTools() == null ){
				throw new Exception("UpdateFormSQLParser����parserCommand, ActionToolsû�����á�" );
			}
			
			SQLParserAble partAble = SQLParserFactory.getQueryDefineInterpreter(config.getFormPart() );
			
			if( partAble == null){
				throw new Exception("UpdateFormSQLParser����parserCommand, FormPart������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			
			SQLParserAble dataSetAble = SQLParserFactory.getQueryDefineInterpreter(config.getDataSet() );
			if( dataSetAble == null){
				throw new Exception("UpdateFormSQLParser����parserCommand, DataSet������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			
			CommandForm dataset = dataSetAble.parserDataSetStringCommand(form);
			
			if( dataset == null ){
				throw new Exception("DataSetû��ָ��������ָ������");
			}
			
			CommandForm selectForm = partAble.parserSelectCommand(
					DATA_MODE_FOR_UPDATE,
					dataset.getAlias(), 
					form);
			CommandForm whereForm =  partAble.parserWhereCommand(
					DATA_MODE_FOR_UPDATE,
					dataset.getAlias(), 
					form);
			CommandForm orderForm =  partAble.parserOrderCommand( 
					DATA_MODE_FOR_UPDATE,
					dataset.getAlias(), 
					form);
			CommandForm groupbyForm =  partAble.parserGroupbyCommand(
					DATA_MODE_FOR_UPDATE,
					dataset.getAlias(), 
					form);
			
			
			
			//if( config.getFormPart() )
			SQLParserAble actionToolsAble = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if( actionToolsAble == null){
				throw new Exception("UpdateFormSQLParser����parserCommand, ActionTools������ȷ��Ӧ��ȷ��PraserTools��"  );
			}
			
			if( form.getFormActionTools() == null ){
				IActionTools iaction = actionToolsAble.parseFormActionTools();
				form.setFormActionTools(iaction);
			}
			
			/* ����Select��Ӧ������ */
			result = actionToolsAble.parserCommand(
					DATA_MODE_FOR_UPDATE,
					form,
					selectForm,
					whereForm,
					orderForm,
					groupbyForm,
					dataset
					);
			
			logger.debug("UpdateFormSQLParserִ��parserCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("UpdateFormSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("UpdateFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("UpdateFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
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
			logger.debug("UpdateFormSQLParser ִ��executeVOAction��");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			/* ǿ��ת�� */
			logger.debug("executeVOAction ִ�У���queryDefineElementǿ��ת����UpdateForm.");
			UpdateForm config = (UpdateForm)this.getQueryDefineElement();
			
			if( config == null ){
				return result;
			}
			
			if(UtilTools.isNull( config.getCode() )){
				logger.error("UpdateForm��Codeû�����á�");
				return result;
			}
			
			if( UtilTools.isNull(formcode) ){
				logger.error("��ڲ���FormCodeû��ָ����");
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
				logger.error("UpdateFormû������ActionTools��");
				return result;
			}
			
			SQLParserAble actionParser = SQLParserFactory.getQueryDefineInterpreter( config.getActionTools() );
			if(actionParser == null ){
				logger.error("UpdateForm����ActionTools����SQLParserAble����");
				return result;
			}
			
			IActionTools actionTools = actionParser.parseFormActionTools();
			
			if( actionTools == null ){
				logger.error("UpdateForm����ActionTools����SQLParserAbleִ��parseFormActionTools����");
				return result;
			}
			
			IFormActionTools formTools = (IFormActionTools)actionTools ;
			
			IConnectionAble connection = actionParser.parseConnection();
			
			result = formTools.executeUpdate(connection, form, formCommand);
			
			logger.debug("UpdateFormSQLParser ִ��executeVOAction��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("UpdateFormSQLParser::executeVOAction �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("UpdateFormSQLParser::executeVOAction �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("UpdateFormSQLParser::executeVOAction �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}

}