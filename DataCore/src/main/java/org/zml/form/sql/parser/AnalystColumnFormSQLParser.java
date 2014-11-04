package org.zml.form.sql.parser;
import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.data.SQLParameter;
import org.zml.form.bind.AnalystColumn;
import org.zml.util.UtilTools;

public class AnalystColumnFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public AnalystColumnFormSQLParser( AnalystColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof AnalystColumn))
		{
			throw new Exception(" AnalystColumnFormSQLParser only parse AnalystColumn");
		}
		result = true;
		return result;
	}
	
	@Override
	public FieldInfo getSelectField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("AnalystColumnFormSQLParser.getSelectField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			if( UtilTools.isNull( field.getField() ) ){
				logger.warn("��ڲ���field ��field ����Ϊ�ա�");
				return result;
			}
			

			if( UtilTools.isNull( field.getFieldCode() ) ){
				logger.warn("��ڲ���field ��field ����Ϊ�ա�");
				return result;
			}
			
			AnalystColumn config = (AnalystColumn)this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() ) ){
				logger.warn("FieldColumn������field û�����á�");
				return result;
			}
			
			String tmpInputField = UtilTools.getTrim( field.getFieldCode() );
			
			String tmpField = UtilTools.getTrim(  config.getField() ); 
			
			if( !tmpInputField.equalsIgnoreCase(tmpField) ){
				return result;
			}
			
			String fieldf = "";
			if( !UtilTools.isNull( field.getAlias() ) ){
				fieldf = UtilTools.getTrim( field.getAlias() );
				fieldf += ".";
			}
			fieldf += UtilTools.getTrim( field.getField() );
			
			StringBuffer sBuf = new StringBuffer();
			
			if( config.getFunction() != null ){
				sBuf.append( config.getFunction().toString());
				sBuf.append( "(");
			}
			sBuf.append( fieldf );
			if( config.getFunction() != null ){
				sBuf.append( ")" );
			}
			result = new FieldInfo();
			result.setField( sBuf.toString() );
			result.setExtendString( UtilTools.getTrim( field.getFieldCode() ) );
			
			
			if( !UtilTools.isNull(config.getContent())){
				SQLParameter sqlParameter = new SQLParameter();
				sqlParameter.setValue( UtilTools.getTrim(config.getContent()) );
				sqlParameter.setDataType( field.getDataType() );
				
				result.setParameter( sqlParameter );
			}
			
			logger.debug("AnalystColumnFormSQLParser.getSelectFieldִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}	
}