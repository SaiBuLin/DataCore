package org.zml.form.sql.parser;
import java.util.ArrayList;
import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.SQLParameter;
import org.zml.data.SQLString;
import org.zml.form.bind.ConditionColumn;
import org.zml.util.UtilTools;

public class ConditionColumnFormSQLParser extends FormSQLParser implements FormSQLParserAble
{
	public ConditionColumnFormSQLParser( ConditionColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof ConditionColumn))
		{
			throw new Exception(" ConditionColumnFormSQLParser only parse ConditionColumn");
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
			logger.debug("ConditionColumnFormSQLParser.parserWhereString ��ʼ�����á�");
			
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
			
			ConditionColumn config = (ConditionColumn) this.queryDefineElement;
			
			if( UtilTools.isNull( config.getField() ) ){
				logger.error("ConditionColumn������fieldû�����á�");
				return result;
			}
			
			if( UtilTools.isNull(config.getContent())){
				logger.warn("ConditionColumn��Ҫ����content��Ϊֵ��");
				return result;
			}
			
			String tmpFieldCode = UtilTools.getTrim(  config.getField() );
			
			FieldDefine fieldDef = null;
			for( int ii = 0; ii < mSize; ii++ ){
				FieldDefine tmpField = fields.get(ii);
				if( tmpField == null ){
					continue;
				}
				
				String tmpFieldInCode = UtilTools.getTrim( tmpField.getFieldCode()  );
				if( tmpFieldCode.equalsIgnoreCase(tmpFieldInCode)){
					fieldDef = tmpField; 
					break;
				}
			}
			
			if( fieldDef != null ){
				
				result = new SQLString();
				result.setParameters(new ArrayList<SQLParameter>());
				
				StringBuffer sBuf = new StringBuffer();
				
				if( !UtilTools.isNull( fieldDef.getAlias()  ) ){
					sBuf.append( UtilTools.getTrim( fieldDef.getAlias()  ) );
					sBuf.append(".");
				}
				sBuf.append( UtilTools.getTrim( fieldDef.getField() ) );
				sBuf.append("=?");
				
				SQLParameter parameter = new SQLParameter();
				parameter.setDataType( fieldDef.getDataType() );
				parameter.setValue( config.getContent() );
				result.getParameters().add( parameter );
			}
			
			logger.debug("ConditionColumnFormSQLParser.parserWhereStringִ�����.");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}		
	}
}