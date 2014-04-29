package org.zml.data.vo.parser;
import org.zml.data.vo.bind.DataType;
import org.zml.data.vo.bind.FieldValueRelation;
import org.zml.data.vo.bind.ServiceField;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class FieldValueRelationSQLParser extends SQLParser implements SQLParserAble
{
	public FieldValueRelationSQLParser( FieldValueRelation element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldValueRelation))
		{
			throw new Exception(" FieldValueRelationSQLParser only parse FieldValueRelation");
		}
		result = true;
		return result;
	}
	
	@Override
	public CommandForm parserCommand(
			VOForm form,
			CommandForm leftForm,
			CommandForm rightForm, 
			TableRelation tableRelation 
			)throws DataServiceException{
		CommandForm result = null;
		
		try{
			logger.debug("FieldValueRelationSQLParser��ʼִ��parserCommand��");
			if(!( this.checkQueryElementComfort() )){
				return result;
			}
			
			if( form == null ){
				throw new Exception("��ڲ���form Ϊ�ա�");
			}
			
			if( form.getProperties() == null ){
				throw new Exception("��ڲ���form��Properties Ϊ�ա�");
			}
			
			if( leftForm == null ){
				throw new Exception("���leftForm Ϊ�ա�");
			}
			
			if( rightForm == null ){
				throw new Exception("���rightForm Ϊ�ա�");
			}
			
			
			String leftAlias = UtilTools.getTrim( leftForm.getAlias());
			
			String rightAlias = UtilTools.getTrim( rightForm.getAlias());
			
			if( UtilTools.isNull(leftAlias) ){
				throw new Exception("Left Form û�����ñ���alias.");
			}
			
			if( UtilTools.isNull(rightAlias) ){
				throw new Exception("Right Form û�����ñ���alias.");
			}
			
			String leftTable = "";// leftForm.getCommand();
			
			String rightTable = "";// rightForm.getCommand();
			
			if( UtilTools.isNull( leftTable ) ){
				throw new Exception( "LeftForm ��Command������Ϊ�ա�" );
			}
			
			if( UtilTools.isNull( rightTable ) ){
				throw new Exception( "RightForm ��Command������Ϊ�ա�" );
			}
			
			Boolean leftKuohao =  isSQLSelectString( leftTable );
			if( leftKuohao ){
				leftTable = "( " + leftTable + ") ";
			}
			
			Boolean  rightKuohao =  isSQLSelectString( rightTable );
			if( rightKuohao ){
				rightTable = "( " + rightTable + ") ";
			}
			
			String relationString = parserRelationFieldString(
					form,
					leftAlias,
					rightAlias
					);
			
			if(UtilTools.isNull(relationString)){
				throw new Exception("��ϵ�ַ������ɴ���");
			}
			
			StringBuffer sBuf = new StringBuffer();
			
			sBuf.append(" SELECT ");			
			sBuf.append(" * ");			
			sBuf.append(" FROM ");
			
			if( tableRelation == TableRelation.INNER_JOIN ){
				sBuf.append( leftTable );
				sBuf.append(" ");
				
				sBuf.append( leftAlias );
				sBuf.append(" INNER JOIN ");
				
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				
				sBuf.append(" ON ");
				
				sBuf.append(relationString);
				
			}else if ( tableRelation == TableRelation.LEFT_OUTER_JOIN ){
				sBuf.append( leftTable );
				sBuf.append(" ");
				
				sBuf.append( leftAlias );
				sBuf.append(" LEFT OUTER JOIN ");
				
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				
				sBuf.append(" ON ");
				
				sBuf.append(relationString);
			}
			else if ( tableRelation == TableRelation.RIGHT_OUTER_JOIN ){
				sBuf.append( leftTable );
				sBuf.append(" ");
				
				sBuf.append( leftAlias );
				sBuf.append(" RIGHT OUTER JOIN ");
				
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				
				sBuf.append(" ON ");
				
				sBuf.append(relationString);
			}
			else if ( tableRelation == TableRelation.EXISTS ){
				sBuf.append( leftTable );
				sBuf.append(" ");				
				sBuf.append( leftAlias );
				sBuf.append(" WHERE ");
				sBuf.append(" EXISTS  ");
				sBuf.append(" (  ");
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				sBuf.append(" WHERE ");
				sBuf.append(relationString);
				sBuf.append(" )  ");
			}
			else if ( tableRelation == TableRelation.NOT_EXISTS ){
				sBuf.append( leftTable );
				sBuf.append(" ");
				sBuf.append( leftAlias );
				
				sBuf.append(" WHERE ");
				sBuf.append(" NOT EXISTS  ");
				sBuf.append(" (  ");
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				sBuf.append(" WHERE ");
				sBuf.append(relationString);
				sBuf.append(" )  ");
			}
			
			logger.debug("FieldValueRelationSQLParserִ��parserCommand��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FieldValueRelationSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FieldValueRelationSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FieldValueRelationSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
			result = null;
		}
		return result;
	}
	
	@Override
	public String parserRelationFieldString(
			VOForm form,
			String leftalias,
			String rightalias
			) throws DataServiceException{
		
		String result = "";
		try{
			
			if(!( this.checkQueryElementComfort() )){
				return result;
			}

			if(UtilTools.isNull( leftalias )){
				throw new Exception("��Form�ı���Ϊ�գ��޷����й�ϵӳ�䡣");
			}
			
			if(UtilTools.isNull( rightalias )){
				throw new Exception("�ұ�Form�ı���Ϊ�գ��޷����й�ϵӳ�䡣");
			}
			
			String tmpLeftAlias = UtilTools.getTrim( leftalias );
			String tmpRightAlias = UtilTools.getTrim( rightalias );
			
			FieldValueRelation config = (FieldValueRelation) this.queryDefineElement;
			
			if(UtilTools.isNull(config.getField() )){
				throw new Exception("field û�����á�");
			}
			
			String[] leftwords = splitSQLName(config.getField());
			if( leftwords.length != 1 ){
				throw new Exception( " Left Field ���ô��� ֵ ��" + config.getField() ); 
			}
			
			if( form.getProperties() == null ){
				throw new Exception("��ڲ�����Form��Properties ����Ϊ�ա�");
			}
			
			if(!form.getProperties().containsKey(PROPERTY_KEY_FIELDS)){
				throw new Exception("FieldValueRelation������Ҫ���ServiceForm �����õ�Field��Ϣ��");
			}
			
			FieldsConfig fieldProperties = (FieldsConfig)form.getProperties().get(PROPERTY_KEY_FIELDS);
			
			String key = UtilTools.getTrim( config.getField() );
			
			Object field = fieldProperties.getField(key);
			
			Boolean isTChar = false;
			if( field == null ){
				isTChar = true;
			}else if ( field instanceof ServiceField){
				
				DataType dataType = ((ServiceField)field).getDataType();
				
				if( (dataType == DataType.zyhBlob) ||
						 (dataType == DataType.zyhDate)	 ||
						 (dataType == DataType.zyhDatetime)	||
						 (dataType == DataType.zyhString)	||
						 (dataType == DataType.zyhXML)		
						){
					isTChar = true;
				}
				
			}else{
				isTChar = true;
			}
			
			StringBuffer sBuf = new StringBuffer();
			
			sBuf.append( tmpLeftAlias );
			sBuf.append( "." );
			sBuf.append(UtilTools.getTrim( config.getField() ));
			
			sBuf.append( parserFieldLogical( config.getOperation() ) );
			if( isTChar ){
				sBuf.append("'");
			}
			sBuf.append(UtilTools.getTrim( config.getValue()   ));			
			if( isTChar ){
				sBuf.append("'");
			}
			result = sBuf.toString();
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FieldsRelationSQLParser::parserRelationFieldString �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FieldsRelationSQLParser::parserRelationFieldString �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FieldsRelationSQLParser::parserRelationFieldString �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
			result = "";
		}
		
		
		return result;
	}
}