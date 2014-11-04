package org.zml.form.sql.parser;
import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.data.SQLParameter;
import org.zml.form.bind.OrderColumn;
import org.zml.util.UtilTools;

public class OrderColumnFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public OrderColumnFormSQLParser( OrderColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof OrderColumn))
		{
			throw new Exception(" OrderColumnFormSQLParser only parse OrderColumn");
		}
		result = true;
		return result;
	}
	
	@Override
	public FieldInfo getSelectField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("OrderColumnFormSQLParser.getSelectField ��ʼ�����á�");
			
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
			
			OrderColumn config = (OrderColumn)this.queryDefineElement;
			
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
			
			
			result = new FieldInfo();
			result.setField( fieldf );
			result.setExtendString( UtilTools.getTrim( field.getFieldCode() ) );
			
			
			if( !UtilTools.isNull(config.getContent())){
				SQLParameter sqlParameter = new SQLParameter();
				sqlParameter.setValue( UtilTools.getTrim(config.getContent()) );
				sqlParameter.setDataType( field.getDataType() );
				
				result.setParameter( sqlParameter );
			}
			
			logger.debug("OrderColumnFormSQLParser.getSelectFieldִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}	
	
	@Override
	public FieldInfo getOrderField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("OrderColumnFormSQLParser.getOrderField ��ʼ�����á�");
			
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
			
			OrderColumn config = (OrderColumn)this.queryDefineElement;
			
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
			
			
			result = new FieldInfo();
			result.setField( fieldf );
			
			if( config.getOperation() != null ){
				result.setExtendString( UtilTools.getTrim( config.getOperation().toString() ) );
			}else {
				result.setExtendString( "" );
			}
			
			logger.debug("OrderColumnFormSQLParser.getOrderFieldִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
}