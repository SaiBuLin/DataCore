package org.zml.form.sql.parser;
import java.util.ArrayList;
import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.data.SQLParameter;
import org.zml.data.SQLString;
import org.zml.form.bind.Column;
import org.zml.form.bind.ColumnGroup;
import org.zml.util.UtilTools;

public class ColumnGroupFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public ColumnGroupFormSQLParser( ColumnGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof ColumnGroup))
		{
			throw new Exception(" ColumnGroupFormSQLParser only parse ColumnGroup");
		}
		result = true;
		return result;
	}
	
	@Override
	public FieldInfo getSelectField( FieldDefine field ) throws Exception{
		FieldInfo result = null;
		try{
			logger.debug("ColumnGroupFormSQLParser.getSelectField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			ColumnGroup config = (ColumnGroup)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("ColumnGroup的属性Column 需要配置。");
				return result;
			}
			
			int mSize = config.getColumn().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Column column = config.getColumn().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( column );
				if( sable == null ){
					logger.warn("Column没有对应的FormSQLParserAble.");
					continue;
				}
				
				result = sable.getSelectField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("ColumnGroupFormSQLParser.getSelectField执行完毕.");
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
			logger.debug("ColumnGroupFormSQLParser.getSelectField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			ColumnGroup config = (ColumnGroup)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("ColumnGroup的属性Column 需要配置。");
				return result;
			}
			
			int mSize = config.getColumn().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Column column = config.getColumn().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( column );
				if( sable == null ){
					logger.warn("Column没有对应的FormSQLParserAble.");
					continue;
				}
				
				result = sable.getOrderField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("ColumnGroupFormSQLParser.getSelectField执行完毕.");
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
			logger.debug("ColumnGroupFormSQLParser.getGroupField 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("入口参数field为空。");
				return result;
			}
			
			ColumnGroup config = (ColumnGroup)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("ColumnGroup的属性Column 需要配置。");
				return result;
			}
			
			int mSize = config.getColumn().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Column column = config.getColumn().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( column );
				if( sable == null ){
					logger.warn("Column没有对应的FormSQLParserAble.");
					continue;
				}
				
				result = sable.getGroupField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("ColumnGroupFormSQLParser.getGroupField执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}

	/**
	 * 获得条件
	 * @param alias
	 * @param field
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserWhereString( List<FieldDefine> fields ) throws Exception{
		SQLString result = null;
		try{
			logger.debug("ColumnGroupFormSQLParser.parserWhereString 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( fields == null ){
				logger.error("入口参数fields为空。");
				return result;
			}
			
			int mSize = fields.size();
			
			if( mSize == 0 ){
				logger.error("入口参数fields为空。");
				return result;
			}
			
			ColumnGroup config = (ColumnGroup) this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.error("ColumnGroup的属性column没有配置。");
				return result;
			}
			
			int iiSize = config.getColumn().size();
			if( iiSize == 0 ){
				logger.error("ColumnGroup的属性column没有配置。");
				return result;
			}
			result = new SQLString();
			result.setParameters(new ArrayList<SQLParameter>());
			int mCount = 0;
			StringBuffer sBuf = new StringBuffer();
			sBuf.append("(");
			for( int ii = 0; ii < iiSize; ii++ ){
				Column column = config.getColumn().get(ii);
				FormSQLParserAble sAble = FormSQLParserFactory.getQueryDefineInterpreter( column );
				if( sAble == null ){
					logger.error("ColumnGroup的属性column没有对应FormSQLParserAble。");
					continue;
				}
				
				SQLString resSQL = sAble.parserWhereString(fields);
				if( resSQL == null ){
					continue;
				}
				
				if( UtilTools.isNull(resSQL.getSqlString()) ){
					continue;
				}
				
				if( mCount > 0 ){
					sBuf.append(" AND " );
				}
				
				sBuf.append( resSQL.getSqlString() );
				
				if( resSQL.getParameters() != null ){
					result.getParameters().addAll( resSQL.getParameters() );
				}
				
				mCount++;
			}
			sBuf.append(")");
			
			
			result.setSqlString( sBuf.toString() );
			
			logger.debug("ColumnGroupFormSQLParser.parserWhereString执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}		
	}
}