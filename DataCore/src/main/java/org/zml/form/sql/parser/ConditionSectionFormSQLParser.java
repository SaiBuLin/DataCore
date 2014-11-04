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
			logger.debug("ConditionSectionFormSQLParser.parserWhereString ��ʼ�����á�");
			
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
			
			logger.debug("���ζ�ȡFieldDefine ��������WhereString ��������");			
			ConditionSection config = (ConditionSection)this.queryDefineElement;
			
			if( config.getCondition() == null ){
				logger.error("ConditionSectionû����������condition.");
				return result;
			}
			
			FormSQLParserAble sAble = FormSQLParserFactory.getQueryDefineInterpreter(config.getCondition());
			if( sAble == null ){
				logger.error("ConditionSection������conditionû�ж�Ӧ��FormSQLParserAble��");
				return result;
			}
			
			result = sAble.parserWhereString( fields );
			
			logger.debug("ConditionSectionFormSQLParser.parserWhereStringִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}		
	}
}