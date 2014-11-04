package org.zml.schema.parser.sql;

import java.util.ArrayList;
import java.util.List;

import org.zml.data.FieldInfo;
import org.zml.data.SQLString;
import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Form;

public class FormSQLParser extends SQLParser implements SQLParserAble
{
	public FormSQLParser( Form element)
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
		if ( !(this.getQueryDefineElement() instanceof Form))
		{
			throw new Exception(" FormSQLParser only parse Form");
		}
		result = true;
		return result;
	}
	
	/**
	 * 该方法， 用于SchemaConfig, 获得对应SQL 文
	 * @param formcode
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserSQLString( FormNode formrequest ) throws Exception{
		SQLString result = null;
		try{
			logger.debug("FormSQLParser.parserSQLString 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				throw new Exception("入口参数formrequest是null。");
			}
			
			Form config = (Form)this.queryDefineElement;
			
			if( config.getCommand() == null ){
				throw new Exception("form属性command为空， 这个需要配置。");
			}
			
			if( config.getField() == null ){
				throw new Exception("form需要配置Field属性。");
			}
			
			/* 生成SQL  */
			SQLParserAble sqlAble = SQLParserFactory.getQueryDefineInterpreter( config.getCommand()  );
			
			if( sqlAble == null ){
				throw new Exception("form 属性command没有对应的SQLParserAble.");
			}
			
			String content = config.getContent();
			
			if( !config.getOnlytable() ){
				content = "(" + content + ")";
			}
			
			result = sqlAble.parserSQLString( config.getField(), config.getAlias(), content , formrequest );			
			logger.debug("FormSQLParser.parserSQLString 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
		
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的SELECT 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getSelectFields(String alias,FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		
		try{
			logger.debug("FormSQLParser.getSelectFields 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				throw new Exception("入口参数formrequest是null。");
			}
			
			Form config = (Form)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("form属性command为空， 这个需要配置。");
			}
			
			
			
			
			
			
			logger.debug("FormSQLParser.getSelectFields 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}		
	}
}