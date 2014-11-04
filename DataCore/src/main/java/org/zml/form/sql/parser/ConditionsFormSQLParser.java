package org.zml.form.sql.parser;
import java.util.ArrayList;
import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.SQLParameter;
import org.zml.data.SQLString;
import org.zml.form.bind.Condition;
import org.zml.form.bind.Conditions;
import org.zml.util.UtilTools;

public class ConditionsFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public ConditionsFormSQLParser( Conditions element)
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
		if ( !(this.getQueryDefineElement() instanceof Conditions))
		{
			throw new Exception(" ConditionsFormSQLParser only parse Conditions");
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
			Conditions config = (Conditions)this.queryDefineElement;
			
			if( config.getCondition() == null ){
				logger.error("ConditionSection没有配置属性condition.");
				return result;
			}
			result = new SQLString();
			result.setParameters(new ArrayList<SQLParameter>());
			StringBuffer sBuf = new StringBuffer();
			
			if( config.getBracket() ){
				sBuf.append("(");
			}
			int nCount = 0;
			int iiSize = config.getCondition().size();
			for( int ii = 0; ii < iiSize; ii++ ){
				
				Condition condition = config.getCondition().get(ii);
				FormSQLParserAble sAble = FormSQLParserFactory.getQueryDefineInterpreter( condition );
				if( sAble == null ){
					logger.error("ConditionSection的属性condition没有对应的FormSQLParserAble。");
					continue;
				}
				
				SQLString resSQL = sAble.parserWhereString(fields);
				
				if( resSQL == null ){
					continue;
				}
				
				if( UtilTools.isNull( resSQL.getSqlString() )){
					continue;
				}
				
				if( ( nCount > 0 ) && ( config.getOperation() != null ) ){
					sBuf.append( config.getOperation().toString()  );
				}
				
				sBuf.append(resSQL.getSqlString());
				
				if( resSQL.getParameters() != null ){
					result.getParameters().addAll(  resSQL.getParameters() );
				}
				nCount++;
			}
			
			if( config.getBracket() ){
				sBuf.append(")");
			}
			
			result.setSqlString( sBuf.toString() );
			
			logger.debug("ConditionSectionFormSQLParser.parserWhereString执行完毕.");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}		
	}
}