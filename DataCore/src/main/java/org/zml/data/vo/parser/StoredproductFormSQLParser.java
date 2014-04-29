package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.StoredproductForm;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class StoredproductFormSQLParser extends SQLParser implements SQLParserAble
{
	public StoredproductFormSQLParser( StoredproductForm element)
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
		if ( !(this.getQueryDefineElement() instanceof StoredproductForm))
		{
			throw new Exception(" StoredproductFormSQLParser only parse StoredproductForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("StoredproductFormSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("StoredproductFormSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			StoredproductForm config = (StoredproductForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("StoredproductFormSQLParser����loadSchemas, queryDefineElement����ΪStoredproductForm����" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("StoredproductFormSQLParser ��ActionTools ����Ϊ�գ��޷��������ݷ���");
			}
			
			logger.debug("StoredproductFormSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("StoredproductFormSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("StoredproductFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("StoredproductFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("StoredproductFormSQLParser��ʼִ��parserCommand��");
			
			if( !this.checkQueryElementComfort() ){
				return result;
			}
			
			StoredproductForm config = (StoredproductForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("StoredproductFormSQLParser����parserCommand, queryDefineElement����ΪTransactionForm����" );
			}
			
			
			
			logger.debug("StoredproductFormSQLParserִ��parserCommand��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("StoredproductFormSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("StoredproductFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("StoredproductFormSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
}