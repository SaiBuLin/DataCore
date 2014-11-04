package org.zml.form.sql.parser;
import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.SQLString;
import org.zml.form.bind.ConditionSection;

public class ConditionSectionFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public ConditionSectionFormSQLParser( ConditionSection element)
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
		if ( !(this.getQueryDefineElement() instanceof ConditionSection))
		{
			throw new Exception(" ConditionSectionFormSQLParser only parse ConditionSection");
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
			logger.debug("ConditionSectionFormSQLParser.parserWhereString 开始被调用。");
			
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
			
			logger.debug("依次读取FieldDefine 用来进行WhereString 条件生成");			
			ConditionSection config = (ConditionSection)this.queryDefineElement;
			
			if( config.getCondition() == null ){
				logger.error("ConditionSection没有配置属性condition.");
				return result;
			}
			
			FormSQLParserAble sAble = FormSQLParserFactory.getQueryDefineInterpreter(config.getCondition());
			if( sAble == null ){
				logger.error("ConditionSection的属性condition没有对应的FormSQLParserAble。");
				return result;
			}
			
			result = sAble.parserWhereString( fields );
			
			logger.debug("ConditionSectionFormSQLParser.parserWhereString执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}		
	}
}