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
			logger.debug("FormGroupSQLParserִ��loadSchemas");
			if( this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null ){
				throw new Exception("FormGroupSQLParser����loadSchemas��ڲ���schemaΪ�ա�" );
			}
			
			
			FormGroup config = (FormGroup)this.queryDefineElement;
			
			if( config == null){
				throw new Exception("FormGroupSQLParser����loadSchemas, queryDefineElement����ΪFormGroup����" );
			}
			
			if( config.getForm() == null ){
				throw new Exception("FormGroupSQLParser����loadSchemas, queryDefineElement����ΪFormGroup����" );
			}
			
			int mSize = config.getForm().size();
			
			if( mSize == 0 ){
				logger.error("FormGroupSQLParser����loadSchemas, ��XML�и�VO û������Form�б�" );
				throw new Exception("FormGroupSQLParser����loadSchemas, queryDefineElement����ΪFormGroup����" );
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				Form form = config.getForm().get(ii);
				SQLParserAble iable = SQLParserFactory.getQueryDefineInterpreter( form );
				
				if( iable == null )continue;
				logger.debug("FormGroupSQLParser����loadSchemas, װ��Form��" );
				iable.loadSchemas( schema, properties);
			}
			
			
			logger.debug("FormGroupSQLParser��LoadVODefineִ����ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormGroupSQLParser::loadSchemas �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FormGroupSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormGroupSQLParser::loadSchemas �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}	

}