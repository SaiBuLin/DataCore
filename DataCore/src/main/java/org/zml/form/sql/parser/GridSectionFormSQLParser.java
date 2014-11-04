package org.zml.form.sql.parser;
import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.form.bind.GridSection;

public class GridSectionFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public GridSectionFormSQLParser( GridSection element)
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
		if ( !(this.getQueryDefineElement() instanceof GridSection))
		{
			throw new Exception(" GridSectionFormSQLParser only parse GridSection");
		}
		result = true;
		return result;
	}
	
	@Override
	public FieldInfo getSelectField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("GridSectionFormSQLParser.getSelectField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			GridSection config = (GridSection)this.queryDefineElement;
			
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
			logger.debug("GridSectionFormSQLParser.getSelectFieldִ�����.");
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
			logger.debug("GridSectionFormSQLParser.getOrderField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			GridSection config = (GridSection)this.queryDefineElement;
			
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
			logger.debug("GridSectionFormSQLParser.getOrderFieldִ�����.");
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
			logger.debug("GridSectionFormSQLParser.getGroupField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			GridSection config = (GridSection)this.queryDefineElement;
			
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
			logger.debug("GridSectionFormSQLParser.getGroupFieldִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
}