package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.Field;
import org.zml.data.vo.bind.FieldGroup;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class FieldGroupSQLParser extends SQLParser implements SQLParserAble
{
	public FieldGroupSQLParser( FieldGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldGroup))
		{
			throw new Exception(" FieldGroupSQLParser only parse FieldGroup");
		}
		result = true;
		return result;
	}
	
	@Override 
	public void loadFieldsProperties(Map<String,Object> fieldProperties) throws DataServiceException{
		
		try{
			logger.debug("FieldGroupSQLParser开始执行LoadVODefine。");	
			
			if( fieldProperties == null ){
				throw new Exception("loadFieldsProperties的入口参数fieldProperties为空。");
			}
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			if( config == null ){
				throw new Exception("强制转换到 错误。");
			}
			
			if( config.getField() == null ){
				throw new Exception("FieldGroup 没有配置Field");
			}
			
			int mSize = config.getField().size();
			
			if ( mSize == 0 ){
				throw new Exception("FieldGroup没有配置Field列表。");
			}
			
			for( int ii = 0; ii < mSize; ii++ ){
				Field field = config.getField().get(ii);
				if( field == null ){
					logger.error("FieldGroup的Field 成员为空。");
					continue;
				}
				
				SQLParserAble fieldAble = SQLParserFactory.getQueryDefineInterpreter(field);
				if( fieldAble == null ){
					logger.error("FieldGroup的Field成员没有对应的ParserTools类。");
					continue;
				}
				
				fieldAble.loadFieldsProperties( fieldProperties );
			}
			
			logger.debug("FieldGroupSQLParser执行loadFieldsProperties完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FieldGroupSQLParser::loadFieldsProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				
				logger.error("FieldGroupSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FieldGroupSQLParser::loadFieldsProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
	

	
}