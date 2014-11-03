package org.zml.schema.parser.sql;
import java.util.List;

import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Field;
import org.zml.schema.bind.Query;

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
			logger.debug("FormSQLParser.parserSQLString 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				throw new Exception("入口参数formrequest是null。");
			}
			
			Query config = (Query)this.queryDefineElement;
			
			
			
			
				
			logger.debug("FormSQLParser.parserSQLString 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	
	
}