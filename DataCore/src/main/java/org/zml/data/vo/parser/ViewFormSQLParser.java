package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.ViewForm;
import org.zml.data.vo.exception.DataServiceException;
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

	
}