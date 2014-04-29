package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.FormLibrary;
import org.zml.data.vo.bind.Schema;
import org.zml.util.UtilTools;

public class FormLibrarySQLParser extends SQLParser implements SQLParserAble
{
	public FormLibrarySQLParser( FormLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof FormLibrary))
		{
			throw new Exception(" FormLibrarySQLParser only parse FormLibrary");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadSchemas( Schema schema, Map<String, Object> properties ) throws Exception{
		try{
			logger.debug("FormLibrarySQLParser开始执行loadSchemas。");	
			
			if(!this.checkQueryElementComfort()){
				return;
			}
			
			if( schema == null){
				throw new NullPointerException("FormLibrarySQLParser的loadSchemas的入口参数 schema 为空。");
			}
			
			FormLibrary config = (FormLibrary)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement 转换成SetStatus错误。 ");
			}
			
			if( config.getForm() == null ){
				logger.error("FormLibrary 没有配置对应的form.");
				return;
			}
			
			SQLParserAble libraryAble = SQLParserFactory.getQueryDefineInterpreter(config.getForm());
			if( libraryAble == null ){
				logger.error("FormLibrary的form 没有配置对应的SQLParserAble.");
				return;
			}
			libraryAble.loadSchemas(schema, properties);
			
			logger.debug("FormLibrarySQLParser执行loadSchemas完毕。");	
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("FormLibrarySQLParser::loadSchemas 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("FormLibrarySQLParser::loadSchemas 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("FormLibrarySQLParser::loadSchemas 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
}