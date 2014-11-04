package org.zml.form.sql.parser;
import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.data.SQLString;
import org.zml.form.bind.Section;
import org.zml.form.bind.SectionGroup;

public class SectionGroupFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public SectionGroupFormSQLParser( SectionGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof SectionGroup))
		{
			throw new Exception(" SectionGroupFormSQLParser only parse SectionGroup");
		}
		result = true;
		return result;
	}
	
	@Override
	public FieldInfo getSelectField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("SectionGroupFormSQLParser.getSelectField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			SectionGroup config = (SectionGroup)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("SectionGroup������section ��Ҫ���á�");
				return result;
			}
			
			int mSize = config.getSection().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Section section = config.getSection().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( section );
				if( sable == null ){
					logger.warn("Sectionû�ж�Ӧ��FormSQLParserAble.");
					continue;
				}
				
				result = sable.getSelectField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("SectionGroupFormSQLParser.getSelectFieldִ�����.");
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
			logger.debug("SectionGroupFormSQLParser.getSelectField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			SectionGroup config = (SectionGroup)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("SectionGroup������section ��Ҫ���á�");
				return result;
			}
			
			int mSize = config.getSection().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Section section = config.getSection().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( section );
				if( sable == null ){
					logger.warn("Sectionû�ж�Ӧ��FormSQLParserAble.");
					continue;
				}
				
				result = sable.getOrderField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("SectionGroupFormSQLParser.getSelectFieldִ�����.");
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
			logger.debug("SectionGroupFormSQLParser.getGroupField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			SectionGroup config = (SectionGroup)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("SectionGroup������section ��Ҫ���á�");
				return result;
			}
			
			int mSize = config.getSection().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Section section = config.getSection().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( section );
				if( sable == null ){
					logger.warn("Sectionû�ж�Ӧ��FormSQLParserAble.");
					continue;
				}
				
				result = sable.getGroupField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("SectionGroupFormSQLParser.getGroupFieldִ�����.");
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
			logger.debug("SectionGroupFormSQLParser.getGroupField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( fields == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			SectionGroup config = (SectionGroup)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("SectionGroup������section ��Ҫ���á�");
				return result;
			}
			
			int mSize = config.getSection().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Section section = config.getSection().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( section );
				if( sable == null ){
					logger.warn("Sectionû�ж�Ӧ��FormSQLParserAble.");
					continue;
				}
				
				result = sable.parserWhereString( fields );
				if( result != null ){
					break;
				}				
			}
			logger.debug("SectionGroupFormSQLParser.getGroupFieldִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
}