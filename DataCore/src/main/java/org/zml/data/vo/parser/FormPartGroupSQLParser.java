package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FormPart;
import org.zml.data.vo.bind.FormPartGroup;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class FormPartGroupSQLParser extends SQLParser implements SQLParserAble
{
	public FormPartGroupSQLParser( FormPartGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FormPartGroup))
		{
			throw new Exception(" FormPartGroupSQLParser only parse FormPartGroup");
		}
		result = true;
		return result;
	}
	
	@Override 
	public void loadFieldsProperties( FieldsConfig fieldProperties) throws DataServiceException{
		try{
			logger.debug("FormPartGroupSQLParser��ʼִ��loadFieldsProperties��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return;
			}
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties ��ڲ���fieldPropertiesΪ�ա�");
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup ������formPart û�����á�");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup ������formPart ��ԱΪ�ա�");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup������formPart�ĳ�ԱΪ�ա�");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup������formPartû�ж�Ӧ��ParserTools�ࡣ");
					continue;
				}
				formpartAble.loadFieldsProperties(fieldProperties);
			}
		
			logger.debug("FormPartGroupSQLParserִ��loadFieldsProperties��ϡ�");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::loadFieldsProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::loadFieldsProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
	
	@Override
	public CommandForm parserSelectCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("FormPartGroupSQLParser��ʼִ��parserSelectCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup ������formPart û�����á�");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup ������formPart ��ԱΪ�ա�");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup������formPart�ĳ�ԱΪ�ա�");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup������formPartû�ж�Ӧ��ParserTools�ࡣ");
					continue;
				}
				result = formpartAble.parserSelectCommand(index, alias,form);
				
				if( result != null ){
					logger.debug("FormPartGroupSQLParserִ��parserSelectCommand�л��Select Column ���֡�  ");	
					break;
				}
			}
			
			logger.debug("FormPartGroupSQLParserִ��parserSelectCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::parserSelectCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::parserSelectCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::parserSelectCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public CommandForm parserWhereCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("FormPartGroupSQLParser��ʼִ��parserWhereCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup ������formPart û�����á�");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup ������formPart ��ԱΪ�ա�");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup������formPart�ĳ�ԱΪ�ա�");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup������formPartû�ж�Ӧ��ParserTools�ࡣ");
					continue;
				}
				result = formpartAble.parserWhereCommand(index, alias, form);
				
				if( result != null ){
					logger.debug("FormPartGroupSQLParserִ��parserWhereCommand�л��Where Column ���֡�  ");	
					break;
				}
			}
			
			logger.debug("FormPartGroupSQLParserִ��parserWhereCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::parserSelectCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::parserSelectCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::parserSelectCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public CommandForm parserOrderCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("FormPartGroupSQLParser��ʼִ��parserOrderCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup ������formPart û�����á�");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup ������formPart ��ԱΪ�ա�");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup������formPart�ĳ�ԱΪ�ա�");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup������formPartû�ж�Ӧ��ParserTools�ࡣ");
					continue;
				}
				result = formpartAble.parserOrderCommand(index, alias, form);
				
				if( result != null ){
					logger.debug("FormPartGroupSQLParserִ��parserOrderCommand�л��Order Column ���֡�  ");	
					break;
				}
			}
			
			logger.debug("FormPartGroupSQLParserִ��parserOrderCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::parserOrderCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::parserOrderCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::parserOrderCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
	@Override
	public CommandForm parserGroupbyCommand(
			int index,
			String alias,
			VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			logger.debug("FormPartGroupSQLParser��ʼִ��parserGroupbyCommand��");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup ������formPart û�����á�");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup ������formPart ��ԱΪ�ա�");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup������formPart�ĳ�ԱΪ�ա�");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup������formPartû�ж�Ӧ��ParserTools�ࡣ");
					continue;
				}
				result = formpartAble.parserGroupbyCommand( index, alias, form );
				
				if( result != null ){
					logger.debug("FormPartGroupSQLParserִ��parserGroupbyCommand�л��GroupBy Column ���֡�  ");	
					break;
				}
			}
			
			logger.debug("FormPartGroupSQLParserִ��parserGroupbyCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::parserGroupbyCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::parserGroupbyCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::parserGroupbyCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
}