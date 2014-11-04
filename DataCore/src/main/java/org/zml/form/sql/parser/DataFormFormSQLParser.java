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
			logger.debug("DataFormFormSQLParser.getSelectField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			if( UtilTools.isNull( field.getField() ) ){
				logger.warn("入口参数field 中field 属性为空。");
				return result;
			}
			

			if( UtilTools.isNull( field.getFieldCode() ) ){
				logger.warn("入口参数field 中field 属性为空。");
				return result;
			}
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("入口参数DataForm的属性Section为空。");
				return result;
			}
			
			FormSQLParserAble sqlformparserable = FormSQLParserFactory.getQueryDefineInterpreter(  config.getSection() );
			if( sqlformparserable == null ){
				logger.warn("DataForm的属性section没有对应的FormSQLParserAble.");
				return result;
			}
			
			result = sqlformparserable.getSelectField( field );
			
			
			logger.debug("DataFormFormSQLParser.getSelectField执行完毕.");
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
			logger.debug("DataFormFormSQLParser.getOrderField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			if( UtilTools.isNull( field.getField() ) ){
				logger.warn("入口参数field 中field 属性为空。");
				return result;
			}
			

			if( UtilTools.isNull( field.getFieldCode() ) ){
				logger.warn("入口参数field 中field 属性为空。");
				return result;
			}
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("入口参数DataForm的属性Section为空。");
				return result;
			}
			
			FormSQLParserAble sqlformparserable = FormSQLParserFactory.getQueryDefineInterpreter(  config.getSection() );
			if( sqlformparserable == null ){
				logger.warn("DataForm的属性section没有对应的FormSQLParserAble.");
				return result;
			}
			
			result = sqlformparserable.getSelectField( field );
			
			logger.debug("DataFormFormSQLParser.getOrderField执行完毕.");
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
			logger.debug("DataFormFormSQLParser.getGroupField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			if( UtilTools.isNull( field.getField() ) ){
				logger.warn("入口参数field 中field 属性为空。");
				return result;
			}
			

			if( UtilTools.isNull( field.getFieldCode() ) ){
				logger.warn("入口参数field 中field 属性为空。");
				return result;
			}
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("入口参数DataForm的属性Section为空。");
				return result;
			}
			
			FormSQLParserAble sqlformparserable = FormSQLParserFactory.getQueryDefineInterpreter(  config.getSection() );
			if( sqlformparserable == null ){
				logger.warn("DataForm的属性section没有对应的FormSQLParserAble.");
				return result;
			}
			
			result = sqlformparserable.getSelectField( field );
			
			logger.debug("DataFormFormSQLParser.getGroupField执行完毕.");
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
			logger.debug("DataFormFormSQLParser.getGroupField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( fields == null ){
				logger.warn("入口参数fields为空。");
				return result;
			}
			
			if( fields.size() == 0 ){
				logger.warn("入口参数fields为空。");
				return result;
			}
			
			DataForm config = (DataForm)this.queryDefineElement;
			
			if( config.getSection() == null ){
				logger.warn("入口参数DataForm的属性Section为空。");
				return result;
			}
			
			FormSQLParserAble sqlformparserable = FormSQLParserFactory.getQueryDefineInterpreter(  config.getSection() );
			if( sqlformparserable == null ){
				logger.warn("DataForm的属性section没有对应的FormSQLParserAble.");
				return result;
			}
			
			result = sqlformparserable.parserWhereString( fields );
			
			logger.debug("DataFormFormSQLParser.parserWhereString执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
}