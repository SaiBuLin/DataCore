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
			logger.debug("FormPartGroupSQLParser开始执行loadFieldsProperties。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return;
			}
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties 入口参数fieldProperties为空。");
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup 的属性formPart 没有配置。");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup 的属性formPart 成员为空。");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup的属性formPart的成员为空。");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup的属性formPart没有对应的ParserTools类。");
					continue;
				}
				formpartAble.loadFieldsProperties(fieldProperties);
			}
		
			logger.debug("FormPartGroupSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
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
			logger.debug("FormPartGroupSQLParser开始执行parserSelectCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup 的属性formPart 没有配置。");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup 的属性formPart 成员为空。");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup的属性formPart的成员为空。");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup的属性formPart没有对应的ParserTools类。");
					continue;
				}
				result = formpartAble.parserSelectCommand(index, alias,form);
				
				if( result != null ){
					logger.debug("FormPartGroupSQLParser执行parserSelectCommand中获得Select Column 部分。  ");	
					break;
				}
			}
			
			logger.debug("FormPartGroupSQLParser执行parserSelectCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::parserSelectCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::parserSelectCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::parserSelectCommand 抛出异常， 异常信息：" + localMessage);
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
			logger.debug("FormPartGroupSQLParser开始执行parserWhereCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup 的属性formPart 没有配置。");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup 的属性formPart 成员为空。");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup的属性formPart的成员为空。");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup的属性formPart没有对应的ParserTools类。");
					continue;
				}
				result = formpartAble.parserWhereCommand(index, alias, form);
				
				if( result != null ){
					logger.debug("FormPartGroupSQLParser执行parserWhereCommand中获得Where Column 部分。  ");	
					break;
				}
			}
			
			logger.debug("FormPartGroupSQLParser执行parserWhereCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::parserSelectCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::parserSelectCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::parserSelectCommand 抛出异常， 异常信息：" + localMessage);
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
			logger.debug("FormPartGroupSQLParser开始执行parserOrderCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup 的属性formPart 没有配置。");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup 的属性formPart 成员为空。");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup的属性formPart的成员为空。");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup的属性formPart没有对应的ParserTools类。");
					continue;
				}
				result = formpartAble.parserOrderCommand(index, alias, form);
				
				if( result != null ){
					logger.debug("FormPartGroupSQLParser执行parserOrderCommand中获得Order Column 部分。  ");	
					break;
				}
			}
			
			logger.debug("FormPartGroupSQLParser执行parserOrderCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::parserOrderCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::parserOrderCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::parserOrderCommand 抛出异常， 异常信息：" + localMessage);
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
			logger.debug("FormPartGroupSQLParser开始执行parserGroupbyCommand。");	
			
			if( !( this.checkQueryElementComfort() ) ){
				return result;
			}
			
			FormPartGroup config = (FormPartGroup)this.queryDefineElement;
			
			if( config.getFormPart() == null ){
				throw new Exception("FormPartGroup 的属性formPart 没有配置。");
			}
			
			
			int mSize = config.getFormPart().size();
			if( mSize == 0 ){
				throw new Exception("FormPartGroup 的属性formPart 成员为空。");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				FormPart formPart = config.getFormPart().get(ii);
				if( formPart == null ){
					logger.error("FormPartGroup的属性formPart的成员为空。");
					continue;
				}
				SQLParserAble formpartAble = SQLParserFactory.getQueryDefineInterpreter( formPart );
				if( formpartAble == null ){
					logger.error("FormPartGroup的属性formPart没有对应的ParserTools类。");
					continue;
				}
				result = formpartAble.parserGroupbyCommand( index, alias, form );
				
				if( result != null ){
					logger.debug("FormPartGroupSQLParser执行parserGroupbyCommand中获得GroupBy Column 部分。  ");	
					break;
				}
			}
			
			logger.debug("FormPartGroupSQLParser执行parserGroupbyCommand完毕。");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormPartGroupSQLParser::parserGroupbyCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormPartGroupSQLParser::parserGroupbyCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormPartGroupSQLParser::parserGroupbyCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return null;
	}
	
}