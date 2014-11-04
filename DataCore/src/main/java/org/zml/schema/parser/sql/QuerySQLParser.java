package org.zml.schema.parser.sql;

import java.util.ArrayList;
import java.util.List;

import org.zml.data.FieldInfo;
import org.zml.data.SQLParameter;
import org.zml.data.SQLString;
import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Field;
import org.zml.schema.bind.Query;
import org.zml.util.UtilTools;

public class QuerySQLParser extends SQLParser implements SQLParserAble
{
	public QuerySQLParser( Query element)
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
		if ( !(this.getQueryDefineElement() instanceof Query))
		{
			throw new Exception(" QuerySQLParser only parse Query");
		}
		result = true;
		return result;
	}
	
	/**
	 * �ýӿ���command ʵ��
	 * @param field
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserSQLString( Field field, String alias, String content, FormNode formrequest) throws Exception{
		SQLString result = null;
		try{
			logger.debug("QuerySQLParser.parserSQLString ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				throw new Exception("��ڲ���formrequest��null��");
			}
			
			if( field == null ){
				throw new Exception("��ڲ���fieldΪ�ա�");
			}
			
			if( UtilTools.isNull(content)){
				throw new Exception("��ڲ���content Ϊ�գ� ����ڲ�����Ҫ�����Ӧֵ��");
			}
			
			//Query config = (Query)this.queryDefineElement;
			
			SQLParserAble fieldable = SQLParserFactory.getQueryDefineInterpreter(field);
			if( fieldable == null ){
				throw new Exception("��ڲ���fieldʵ����SQLParserAble����");
			}
			
			/* ���Select Field  */
			List<FieldInfo> selectfields = fieldable.getSelectFields(alias, formrequest);
			if( selectfields == null ){
				throw new Exception(" SELECT ѡ���б����ô��� ");
			}
			
			int selectsize = selectfields.size();
			if( selectsize == 0 ){
				throw new Exception(" SELECT ѡ���б����ô��� ");
			}
			
			
			
			/* ���Condition Field  */
			SQLString whereString = fieldable.parserSQLStringForWhereString( alias, formrequest );
			
			/* ���Condition Field  */
			List<FieldInfo> orderByfields = fieldable.getOrderByFields( alias, formrequest );
			
			int orderfsize = 0;
			if( orderByfields != null ){
				orderfsize = orderByfields.size();
			}
			
			/* Group by �ֶ��б� */
			List<FieldInfo> groupByfields = fieldable.getGroupByFields( alias, formrequest );
			int groupbyfsize = 0;
			if( groupByfields != null ){
				groupbyfsize = groupByfields.size();
			}
			
			result = new SQLString();
			
			result.setParameters(new ArrayList<SQLParameter>());
			result.setSqlString("");
			
			StringBuffer sBuf = new StringBuffer();
			
			sBuf.append( " SELECT " );
			int nCount = 0;
			for( int ii = 0; ii < selectsize; ii++ ){
				FieldInfo finfo = selectfields.get(ii);
				if( finfo == null )continue;
				
				if( UtilTools.isNull( finfo.getField() ) ){
					logger.warn("FieldInfo ��field����Ϊ�ա�");
					continue;
				}
				
				if( nCount > 0 ){
					sBuf.append(",");
				}
				
//				if( !UtilTools.isNull( alias )){
//					sBuf.append( UtilTools.getTrim( alias ) );
//					sBuf.append(".") ;
//				}
				
				sBuf.append( UtilTools.getTrim( finfo.getField() ) );
				
				if( !UtilTools.isNull( finfo.getExtendString() )){
					sBuf.append(" AS " );					
					sBuf.append( UtilTools.getTrim( finfo.getExtendString()) );
				}
				
				sBuf.append(" ");
				nCount++;
			}
			
			if( whereString != null ){
				if( !UtilTools.isNull( whereString.getSqlString()) ){
					sBuf.append( " WHERE " );
					sBuf.append( UtilTools.getTrim( whereString.getSqlString()) );
				}
			}
			
			sBuf.append(" FROM ");
			
			sBuf.append( UtilTools.getTrim(content) );
			
			if( !UtilTools.isNull( alias )){
				sBuf.append(" ") ;
				sBuf.append( UtilTools.getTrim( alias ) );				
			}
			
			if( orderfsize > 0 ){
				nCount = 0;
				sBuf.append( " ORDER BY " );
				for( int ii = 0; ii < orderfsize; ii++ ){
					FieldInfo finfo = orderByfields.get(ii);
					if( finfo == null )continue;
					
					if( UtilTools.isNull( finfo.getField() ) ){
						logger.warn("FieldInfo ��field����Ϊ�ա�");
						continue;
					}
					
					if( nCount > 0 ){
						sBuf.append(" , ");
					}
					
//					if( !UtilTools.isNull( alias )){
//						sBuf.append( UtilTools.getTrim( alias ) );
//						sBuf.append(".") ;
//					}
					sBuf.append( UtilTools.getTrim( finfo.getField() ) );
					
					if( !UtilTools.isNull(finfo.getExtendString()) ){
						sBuf.append( UtilTools.getTrim( finfo.getExtendString() ) );
					}
					nCount++;
				}
				sBuf.append(" ");
			}
			
			if( groupbyfsize > 0 ){
				nCount = 0;
				sBuf.append( " GROUP BY " );
				for( int ii = 0; ii < groupbyfsize; ii++ ){
					FieldInfo finfo = groupByfields.get(ii);
					if( finfo == null )continue;
					
					if( UtilTools.isNull( finfo.getField() ) ){
						logger.warn("GROUP BY FieldInfo ��field����Ϊ�ա�");
						continue;
					}
					
					if( nCount > 0 ){
						sBuf.append(" , ");
					}
//					if( !UtilTools.isNull( alias )){
//						sBuf.append( UtilTools.getTrim( alias ) );
//						sBuf.append(".") ;
//					}
					sBuf.append( UtilTools.getTrim( finfo.getField() ) );		
					nCount++;
				}
				sBuf.append(" ");
			}
			
			result.setSqlString( sBuf.toString() );
			
			if( whereString.getParameters() != null ){
				result.getParameters().addAll( whereString.getParameters() );
			}
			logger.debug("QuerySQLParser.parserSQLString ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
}