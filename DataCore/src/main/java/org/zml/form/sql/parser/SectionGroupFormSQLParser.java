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
			logger.debug("SectionGroupFormSQLParser.getSelectField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			SectionGroup config = (SectionGroup)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("SectionGroup的属性section 需要配置。");
				return result;
			}
			
			int mSize = config.getSection().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Section section = config.getSection().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( section );
				if( sable == null ){
					logger.warn("Section没有对应的FormSQLParserAble.");
					continue;
				}
				
				result = sable.getSelectField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("SectionGroupFormSQLParser.getSelectField执行完毕.");
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
			logger.debug("SectionGroupFormSQLParser.getSelectField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			SectionGroup config = (SectionGroup)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("SectionGroup的属性section 需要配置。");
				return result;
			}
			
			int mSize = config.getSection().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Section section = config.getSection().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( section );
				if( sable == null ){
					logger.warn("Section没有对应的FormSQLParserAble.");
					continue;
				}
				
				result = sable.getOrderField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("SectionGroupFormSQLParser.getSelectField执行完毕.");
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
			logger.debug("SectionGroupFormSQLParser.getGroupField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			SectionGroup config = (SectionGroup)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("SectionGroup的属性section 需要配置。");
				return result;
			}
			
			int mSize = config.getSection().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Section section = config.getSection().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( section );
				if( sable == null ){
					logger.warn("Section没有对应的FormSQLParserAble.");
					continue;
				}
				
				result = sable.getGroupField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("SectionGroupFormSQLParser.getGroupField执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public SQLString parserWhereString(  List<FieldDefine> fields ) throws Exception{
		SQLString result = null;
		try{
			logger.debug("SectionGroupFormSQLParser.getGroupField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( fields == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			SectionGroup config = (SectionGroup)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("SectionGroup的属性section 需要配置。");
				return result;
			}
			
			int mSize = config.getSection().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Section section = config.getSection().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( section );
				if( sable == null ){
					logger.warn("Section没有对应的FormSQLParserAble.");
					continue;
				}
				
				result = sable.parserWhereString( fields );
				if( result != null ){
					break;
				}				
			}
			logger.debug("SectionGroupFormSQLParser.getGroupField执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
}