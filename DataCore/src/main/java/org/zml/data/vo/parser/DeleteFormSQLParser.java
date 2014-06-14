package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.ActionTools;
import org.zml.data.vo.bind.DataForm;
import org.zml.data.vo.bind.DeleteForm;
import org.zml.data.vo.bind.Schema;
import org.zml.data.vo.exception.DataServiceException;

import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class DeleteFormSQLParser extends SQLParser implements SQLParserAble
{
	public DeleteFormSQLParser( DeleteForm element)
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
		if ( !(this.getQueryDefineElement() instanceof DeleteForm))
		{
			throw new Exception(" DeleteFormSQLParser only parse DeleteForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
					
		try{
			logger.debug("DeleteFormSQLParser��ʼִ��loadSchemas��");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("DeleteFormSQLParser��loadSchemas����ڲ��� schema Ϊ�ա�");
			}
			
			DeleteForm config = (DeleteForm)this.queryDefineElement;
			if( config == null){			
				throw new Exception("DeleteFormSQLParser����loadSchemas, queryDefineElement����ΪDeleteForm����" );
			}
			
			if( (config.getActionTools() == null) && ( properties != null ) ){
				ActionTools actiontools = (ActionTools)properties.get(PROPERTY_KEY_ACTION_TOOL );	
				
				config.setActionTools(actiontools);
			}
			
			if( config.getActionTools() == null){
				throw new Exception("DeleteFormSQLParser ��ActionTools ����Ϊ�գ��޷��������ݷ���");
			}
			
			if( config.getDataSet() != null ){
				SQLParserAble DataSetAble = SQLParserFactory.getQueryDefineInterpreter(config.getDataSet());
				if( DataSetAble != null ){
					DataSetAble.loadSchemas(schema, properties);
				}else{
					logger.error("DeleteForm ��DataSet����PraserAble ʧ�ܡ�");
				}
			}else{
				logger.error("DeleteForm ��DataSetû�����á�");
			}
		
			logger.debug("DeleteFormSQLParserִ��loadSchemas��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("DeleteFormSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("DeleteFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("DeleteFormSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}

	
	
	
}