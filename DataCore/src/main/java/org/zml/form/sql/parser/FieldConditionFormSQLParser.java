package org.zml.form.sql.parser;
import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.SQLString;
import org.zml.form.bind.FieldCondition;

public class FieldConditionFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public FieldConditionFormSQLParser( FieldCondition element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldCondition))
		{
			throw new Exception(" FieldConditionFormSQLParser only parse FieldCondition");
		}
		result = true;
		return result;
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
			logger.debug("FieldConditionFormSQLParser.parserWhereString 开始被调用。");
			
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
			
			FieldCondition config = (FieldCondition) this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.error("FieldCondition的属性column没有配置。");
				return result;
			}
			
			FormSQLParserAble sAble = FormSQLParserFactory.getQueryDefineInterpreter( config.getColumn() );
			if( sAble == null ){
				logger.error("FieldCondition的属性column没有对应FormSQLParserAble。");
				return result;
			}
			
			result = sAble.parserWhereString(fields);
			
			logger.debug("FieldConditionFormSQLParser.parserWhereString执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}		
	}
}