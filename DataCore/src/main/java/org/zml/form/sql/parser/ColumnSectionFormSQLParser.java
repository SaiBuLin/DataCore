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
			logger.debug("ColumnSectionFormSQLParser.getSelectField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			ColumnSection config = (ColumnSection)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("SectionGroup的属性section 需要配置。");
				return result;
			}
			
			FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( config.getColumn() );
			if( sable == null ){
				logger.warn("Section没有对应的FormSQLParserAble.");
				return result;
			}
			
			result = sable.getSelectField( field );
			
			
			logger.debug("ColumnSectionFormSQLParser.getSelectField执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public FieldInfo getOrderField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("ColumnSectionFormSQLParser.getOrderField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			ColumnSection config = (ColumnSection)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("SectionGroup的属性section 需要配置。");
				return result;
			}
			
			FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( config.getColumn() );
			if( sable == null ){
				logger.warn("Section没有对应的FormSQLParserAble.");
				return result;
			}
			
			result = sable.getOrderField( field );
			
			
			logger.debug("ColumnSectionFormSQLParser.getOrderField执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public FieldInfo getGroupField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("ColumnSectionFormSQLParser.getGroupField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			ColumnSection config = (ColumnSection)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("SectionGroup的属性section 需要配置。");
				return result;
			}
			
			FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( config.getColumn() );
			if( sable == null ){
				logger.warn("Section没有对应的FormSQLParserAble.");
				return result;
			}
			
			result = sable.getGroupField( field );
			
			
			logger.debug("ColumnSectionFormSQLParser.getGroupField执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
}