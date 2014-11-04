package org.zml.schema.parser.sql;
import java.util.ArrayList;
import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.form.bind.FormNode;
import org.zml.form.sql.parser.FormSQLParserAble;
import org.zml.form.sql.parser.FormSQLParserFactory;
import org.zml.schema.bind.ServiceField;
import org.zml.util.UtilTools;

public class ServiceFieldSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceFieldSQLParser( ServiceField element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceField))
		{
			throw new Exception(" ServiceFieldSQLParser only parse ServiceField");
		}
		result = true;
		return result;
	}
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��SELECT ���� �ֶ��б�, �ýӿڱ�Field ʵ��
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getSelectFields(String alias, FormNode formrequest) throws Exception{
		 List<FieldInfo> result = new ArrayList<FieldInfo>();
		 try{
			logger.debug("ServiceFieldSQLParser.getSelectFields ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				logger.warn("��ڲ���formrequestΪ�ա�");
				return result;
			}
			
			logger.debug("��ȡServiceField.");
			ServiceField serviceFile = (ServiceField)this.getQueryDefineElement();
			
			if( UtilTools.isNull( serviceFile.getCode() ) ){
				logger.warn(" ServiceField������������code�� ");
				return result;
			}
			
			String tmpFieldCode = UtilTools.getTrim( serviceFile.getCode()  );
			String tmpField = UtilTools.getTrim( serviceFile.getField() );
			
			FormSQLParserAble formParser = FormSQLParserFactory.getQueryDefineInterpreter(formrequest);
			
			if( formParser == null ){
				logger.warn("��ڲ���formrequest û�ж�Ӧ��FormParserAble.");
				return result;
			}
			
			FieldDefine fieldDef = new FieldDefine();
			
			fieldDef.setAlias( alias );
			fieldDef.setField( tmpField );
			fieldDef.setFieldCode( tmpFieldCode );
			
			fieldDef.setDataType( serviceFile.getDataType() );
			
			FieldInfo fieldinfo = formParser.getSelectField(fieldDef);
			if( fieldinfo != null ){			
				result.add(fieldinfo);
			}
			logger.debug("ServiceFieldSQLParser.getSelectFields ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
		
	}
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Where ���� �ֶ��б�
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getConditionFields(String alias, FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Order By ���� �ֶ��б�
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getOrderByFields(String alias, FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Group by ���� �ֶ��б�
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getGroupByFields(String alias, FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
}