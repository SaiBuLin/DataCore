package org.zml.form.sql.parser;
import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.data.SQLString;
import org.zml.form.bind.DataForm;
import org.zml.util.UtilTools;


public class DataFormFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public DataFormFormSQLParser( DataForm element)
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
		if ( !(this.getQueryDefineElement() instanceof DataForm))
		{
			throw new Exception(" DataFormFormSQLParser only parse DataForm");
		}
		result = true;
		return result;
	}
	
	@Override
	public FieldInfo getSelectField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("DataFormFormSQLParser.getSelectField ��ʼ�����á�");
			
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
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("��ڲ���DataForm������SectionΪ�ա�");
				return result;
			}
			
			FormSQLParserAble sqlformparserable = FormSQLParserFactory.getQueryDefineInterpreter(  config.getSection() );
			if( sqlformparserable == null ){
				logger.warn("DataForm������sectionû�ж�Ӧ��FormSQLParserAble.");
				return result;
			}
			
			result = sqlformparserable.getSelectField( field );
			
			
			logger.debug("DataFormFormSQLParser.getSelectFieldִ�����.");
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
			logger.debug("DataFormFormSQLParser.getOrderField ��ʼ�����á�");
			
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
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("��ڲ���DataForm������SectionΪ�ա�");
				return result;
			}
			
			FormSQLParserAble sqlformparserable = FormSQLParserFactory.getQueryDefineInterpreter(  config.getSection() );
			if( sqlformparserable == null ){
				logger.warn("DataForm������sectionû�ж�Ӧ��FormSQLParserAble.");
				return result;
			}
			
			result = sqlformparserable.getSelectField( field );
			
			logger.debug("DataFormFormSQLParser.getOrderFieldִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public FieldInfo getGroupField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("DataFormFormSQLParser.getGroupField ��ʼ�����á�");
			
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
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("��ڲ���DataForm������SectionΪ�ա�");
				return result;
			}
			
			FormSQLParserAble sqlformparserable = FormSQLParserFactory.getQueryDefineInterpreter(  config.getSection() );
			if( sqlformparserable == null ){
				logger.warn("DataForm������sectionû�ж�Ӧ��FormSQLParserAble.");
				return result;
			}
			
			result = sqlformparserable.getSelectField( field );
			
			logger.debug("DataFormFormSQLParser.getGroupFieldִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public SQLString parserWhereString(  List<FieldDefine> fields ) throws Exception{
		SQLString result = null;
		try{
			logger.debug("DataFormFormSQLParser.getGroupField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( fields == null ){
				logger.warn("��ڲ���fieldsΪ�ա�");
				return result;
			}
			
			if( fields.size() == 0 ){
				logger.warn("��ڲ���fieldsΪ�ա�");
				return result;
			}
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("��ڲ���DataForm������SectionΪ�ա�");
				return result;
			}
			
			FormSQLParserAble sqlformparserable = FormSQLParserFactory.getQueryDefineInterpreter(  config.getSection() );
			if( sqlformparserable == null ){
				logger.warn("DataForm������sectionû�ж�Ӧ��FormSQLParserAble.");
				return result;
			}
			
			result = sqlformparserable.parserWhereString( fields );
			
			logger.debug("DataFormFormSQLParser.parserWhereStringִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
}