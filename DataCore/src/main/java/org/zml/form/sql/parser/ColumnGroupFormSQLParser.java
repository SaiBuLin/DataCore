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
			logger.debug("ColumnGroupFormSQLParser.getSelectField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			ColumnGroup config = (ColumnGroup)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("ColumnGroup������Column ��Ҫ���á�");
				return result;
			}
			
			int mSize = config.getColumn().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Column column = config.getColumn().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( column );
				if( sable == null ){
					logger.warn("Columnû�ж�Ӧ��FormSQLParserAble.");
					continue;
				}
				
				result = sable.getSelectField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("ColumnGroupFormSQLParser.getSelectFieldִ�����.");
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
			logger.debug("ColumnGroupFormSQLParser.getSelectField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			ColumnGroup config = (ColumnGroup)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("ColumnGroup������Column ��Ҫ���á�");
				return result;
			}
			
			int mSize = config.getColumn().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Column column = config.getColumn().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( column );
				if( sable == null ){
					logger.warn("Columnû�ж�Ӧ��FormSQLParserAble.");
					continue;
				}
				
				result = sable.getOrderField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("ColumnGroupFormSQLParser.getSelectFieldִ�����.");
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
			logger.debug("ColumnGroupFormSQLParser.getGroupField ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( field == null ){
				logger.warn("��ڲ���fieldΪ�ա�");
				return result;
			}
			
			ColumnGroup config = (ColumnGroup)this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.warn("ColumnGroup������Column ��Ҫ���á�");
				return result;
			}
			
			int mSize = config.getColumn().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Column column = config.getColumn().get(ii);
				
				FormSQLParserAble sable = FormSQLParserFactory.getQueryDefineInterpreter( column );
				if( sable == null ){
					logger.warn("Columnû�ж�Ӧ��FormSQLParserAble.");
					continue;
				}
				
				result = sable.getGroupField( field );
				if( result != null ){
					break;
				}				
			}
			logger.debug("ColumnGroupFormSQLParser.getGroupFieldִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}

	/**
	 * �������
	 * @param alias
	 * @param field
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserWhereString( List<FieldDefine> fields ) throws Exception{
		SQLString result = null;
		try{
			logger.debug("ColumnGroupFormSQLParser.parserWhereString ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( fields == null ){
				logger.error("��ڲ���fieldsΪ�ա�");
				return result;
			}
			
			int mSize = fields.size();
			
			if( mSize == 0 ){
				logger.error("��ڲ���fieldsΪ�ա�");
				return result;
			}
			
			ColumnGroup config = (ColumnGroup) this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.error("ColumnGroup������columnû�����á�");
				return result;
			}
			
			int iiSize = config.getColumn().size();
			if( iiSize == 0 ){
				logger.error("ColumnGroup������columnû�����á�");
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
					logger.error("ColumnGroup������columnû�ж�ӦFormSQLParserAble��");
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
			
			logger.debug("ColumnGroupFormSQLParser.parserWhereStringִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}		
	}
}