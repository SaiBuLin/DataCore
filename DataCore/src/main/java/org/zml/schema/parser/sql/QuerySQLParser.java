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
	 * 该接口由command 实现
	 * @param field
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserSQLString( Field field, String alias, String content, FormNode formrequest) throws Exception{
		SQLString result = null;
		try{
			logger.debug("QuerySQLParser.parserSQLString 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				throw new Exception("入口参数formrequest是null。");
			}
			
			if( field == null ){
				throw new Exception("入口参数field为空。");
			}
			
			if( UtilTools.isNull(content)){
				throw new Exception("入口参数content 为空， 该入口参数需要输入对应值。");
			}
			
			//Query config = (Query)this.queryDefineElement;
			
			SQLParserAble fieldable = SQLParserFactory.getQueryDefineInterpreter(field);
			if( fieldable == null ){
				throw new Exception("入口参数field实例化SQLParserAble错误。");
			}
			
			/* 获得Select Field  */
			List<FieldInfo> selectfields = fieldable.getSelectFields(alias, formrequest);
			if( selectfields == null ){
				throw new Exception(" SELECT 选择列表配置错误。 ");
			}
			
			int selectsize = selectfields.size();
			if( selectsize == 0 ){
				throw new Exception(" SELECT 选择列表配置错误。 ");
			}
			
			
			
			/* 获得Condition Field  */
			SQLString whereString = fieldable.parserSQLStringForWhereString( alias, formrequest );
			
			/* 获得Condition Field  */
			List<FieldInfo> orderByfields = fieldable.getOrderByFields( alias, formrequest );
			
			int orderfsize = 0;
			if( orderByfields != null ){
				orderfsize = orderByfields.size();
			}
			
			/* Group by 字段列表 */
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
					logger.warn("FieldInfo 的field属性为空。");
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
						logger.warn("FieldInfo 的field属性为空。");
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
						logger.warn("GROUP BY FieldInfo 的field属性为空。");
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
			logger.debug("QuerySQLParser.parserSQLString 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
}