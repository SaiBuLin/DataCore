package org.zml.form.sql.parser;
import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.form.bind.ColumnSection;

public class ColumnSectionFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public ColumnSectionFormSQLParser( ColumnSection element)
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
		if ( !(this.getQueryDefineElement() instanceof ColumnSection))
		{
			throw new Exception(" ColumnSectionFormSQLParser only parse ColumnSection");
		}
		result = true;
		return result;
	}
	
	@Override
	public FieldInfo getSelectField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("ColumnSectionFormSQLParser.getSelectField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			ColumnSection config = (ColumnSection)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("SectionGroup������section ��Ҫ���á�");
				return result;
			}
			
			FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( config.getColumn() );
			if( sable == null ){
				logger.warn("Sectionû�ж�Ӧ��FormSQLParserAble.");
				return result;
			}
			
			result = sable.getSelectField( field );
			
			
			logger.debug("ColumnSectionFormSQLParser.getSelectFieldִ�����.");
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
			logger.debug("ColumnSectionFormSQLParser.getOrderField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			ColumnSection config = (ColumnSection)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("SectionGroup������section ��Ҫ���á�");
				return result;
			}
			
			FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( config.getColumn() );
			if( sable == null ){
				logger.warn("Sectionû�ж�Ӧ��FormSQLParserAble.");
				return result;
			}
			
			result = sable.getOrderField( field );
			
			
			logger.debug("ColumnSectionFormSQLParser.getOrderFieldִ�����.");
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
			logger.debug("ColumnSectionFormSQLParser.getGroupField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			ColumnSection config = (ColumnSection)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("SectionGroup������section ��Ҫ���á�");
				return result;
			}
			
			FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( config.getColumn() );
			if( sable == null ){
				logger.warn("Sectionû�ж�Ӧ��FormSQLParserAble.");
				return result;
			}
			
			result = sable.getGroupField( field );
			
			
			logger.debug("ColumnSectionFormSQLParser.getGroupFieldִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
}