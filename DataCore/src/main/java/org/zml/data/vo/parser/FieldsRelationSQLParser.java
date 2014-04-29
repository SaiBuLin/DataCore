package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FieldsRelation;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class FieldsRelationSQLParser extends SQLParser implements SQLParserAble
{
	public FieldsRelationSQLParser( FieldsRelation element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldsRelation))
		{
			throw new Exception(" FieldsRelationSQLParser only parse FieldsRelation");
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
			logger.debug("FieldsRelationSQLParser��ʼִ��parserCommand��");
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
			
			String relationString = this.parserRelationFieldString(
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
			
			logger.debug("FieldsRelationSQLParserִ��parserCommand��ϡ�");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FieldsRelationSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FieldsRelationSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FieldsRelationSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
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
			
			FieldsRelation config = (FieldsRelation) this.queryDefineElement;
			
			if(UtilTools.isNull(config.getLeftfield())){
				throw new Exception("LfetField û�����á�");
			}
			
			String[] leftwords = splitSQLName(config.getLeftfield());
			if( leftwords.length != 1 ){
				throw new Exception( " Left Field ���ô��� ֵ ��" + config.getLeftfield() ); 
			}
			
			if(UtilTools.isNull(config.getRightfield())){
				throw new Exception("LfetField û�����á�");
			}
			
			String[] rightwords = splitSQLName(config.getRightfield());
			if( rightwords.length != 1 ){
				throw new Exception( " Right Field ���ô��� ֵ ��" + config.getRightfield() ); 
			}
			
			StringBuffer sBuf = new StringBuffer();
			
			sBuf.append( tmpLeftAlias );
			sBuf.append( "." );
			sBuf.append(UtilTools.getTrim( config.getLeftfield() ));
			
			sBuf.append( parserFieldLogical( config.getOperation() ) );
			
			sBuf.append( tmpRightAlias );
			sBuf.append( "." );
			sBuf.append(UtilTools.getTrim( config.getRightfield() ));			
			
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