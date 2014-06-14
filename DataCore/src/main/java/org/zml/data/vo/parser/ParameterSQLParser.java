package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.Parameter;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class ParameterSQLParser extends SQLParser implements SQLParserAble
{
	public ParameterSQLParser( Parameter element)
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
		if ( !(this.getQueryDefineElement() instanceof Parameter))
		{
			throw new Exception(" ParameterSQLParser only parse Parameter");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException{
		try{
			logger.debug("ParameterSQLParser开始执行loadProperties。");
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			if( properties == null ){
				throw new Exception( "loadProperties的入口参数properties为空。" );
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception( "Parameter强制转换错误。" );
			}
			
			String key = UtilTools.getTrim( config.getCode());
			
			if(UtilTools.isNull( key )){
				throw new Exception("Parameter 的属性Code 没有配置。");
			}
			logger.debug("ParameterSQLParser 装载属性。");
			
			properties.put( key,  config );
			
			logger.debug("ParameterSQLParser执行loadProperties完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ParameterSQLParser::loadProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("ParameterSQLParser::loadProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ParameterSQLParser::loadProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}

	
}