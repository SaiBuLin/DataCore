package org.zml.schema.parser.sql;
import java.util.ArrayList;
import java.util.List;

import org.zml.data.FieldInfo;
import org.zml.data.SQLParameter;
import org.zml.data.SQLString;
import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Field;
import org.zml.schema.bind.Insert;
import org.zml.util.UtilTools;

public class InsertSQLParser extends SQLParser implements SQLParserAble
{
	public InsertSQLParser( Insert element)
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
		if ( !(this.getQueryDefineElement() instanceof Insert))
		{
			throw new Exception(" InsertSQLParser only parse Insert");
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
	public SQLString parserSQLString( Field field,  String alias, String content, FormNode formrequest) throws Exception{
		SQLString result = null;
		try{
			logger.debug("InsertSQLParser.parserSQLString 开始被调用。");
			
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
			
			result = new SQLString();
			
			result.setParameters(new ArrayList<SQLParameter>());
			result.setSqlString("");
			
			StringBuffer sBuf = new StringBuffer();
			
			sBuf.append( " INSERT INTO " );
			sBuf.append( UtilTools.getTrim(content) );
			sBuf.append(" ( ");
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
				
				sBuf.append( UtilTools.getTrim( finfo.getField() ) );				
				sBuf.append(" ");		
				nCount++;
			}
			sBuf.append(" ) ");		
			sBuf.append(" VALUES ");
			sBuf.append(" ( ");
			nCount = 0;
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
				sBuf.append("? ");
				nCount++;
			}
			sBuf.append(" ) ");	
			
			result.setSqlString( sBuf.toString() );
			
			logger.debug("InsertSQLParser.parserSQLString 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
}