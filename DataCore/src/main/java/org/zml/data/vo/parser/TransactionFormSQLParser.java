package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.bind.TransactionForm;
import org.zml.data.vo.exception.DataServiceException;

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

}