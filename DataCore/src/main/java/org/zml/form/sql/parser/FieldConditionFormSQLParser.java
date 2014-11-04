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
			logger.debug("FieldConditionFormSQLParser.parserWhereString ��ʼ�����á�");
			
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
			
			FieldCondition config = (FieldCondition) this.queryDefineElement;
			
			if( config.getColumn() == null ){
				logger.error("FieldCondition������columnû�����á�");
				return result;
			}
			
			FormSQLParserAble sAble = FormSQLParserFactory.getQueryDefineInterpreter( config.getColumn() );
			if( sAble == null ){
				logger.error("FieldCondition������columnû�ж�ӦFormSQLParserAble��");
				return result;
			}
			
			result = sAble.parserWhereString(fields);
			
			logger.debug("FieldConditionFormSQLParser.parserWhereStringִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}		
	}
}