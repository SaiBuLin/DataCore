package org.zml.schema.parser.sql;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zml.schema.bind.Parameter;
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
	
	/**
	 * 获得属性值
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAttributes() throws Exception{
		Map<String, Object> result = new HashMap<String,Object>();
		try{
			logger.debug("ParameterAttributeCognitron.getAttributes 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			String tmpKey = UtilTools.getTrim( config.getCode() );
			
			if( UtilTools.isNull(tmpKey )){
				throw new Exception(" Parameter 配置错误，没有配置param. ");
			}
			
			result.put(tmpKey, config.getValue() );
			
			logger.debug("ParameterAttributeCognitron.getAttributes 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * 根据attr Name 获得值列表。
	 * @param attrname
	 * @return
	 * @throws Exception
	 */
	public List<Object> getAttribute(String attrname ) throws Exception{
		List<Object> result = new ArrayList<Object>();
		try{
			logger.debug("ParameterAttributeCognitron.getAttribute 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			String tmpKey = UtilTools.getTrim( config.getCode() );
			
			if( UtilTools.isNull(tmpKey )){
				throw new Exception(" Parameter 配置错误，没有配置param. ");
			}
			
			if( this.isMine(attrname)){
			
				result.add( config.getValue() );
			}
			
			logger.debug("ParameterAttributeCognitron.getAttribute 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * 根据属性设置值
	 * @param attrname
	 * @param value
	 * @throws Exception
	 */
	public void setAttribute(String attrname, Object value) throws Exception{
		try{
			logger.debug("ParameterAttributeCognitron.getAttribute 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			String tmpKey = UtilTools.getTrim( config.getCode() );
			
			if( UtilTools.isNull(tmpKey )){
				throw new Exception(" Parameter 配置错误，没有配置param. ");
			}
			
			if( this.isMine(attrname)){
				config.setValue(String.valueOf(value) );
				
			}
			
			logger.debug("ParameterAttributeCognitron.getAttribute 调用完毕。");
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * 判断是否是自己
	 * @param attrname
	 * @throws Exception
	 */
	public boolean isMine(String attrname) throws Exception{
		boolean result = false;
		try{
			logger.debug("ParameterAttributeCognitron.getAttribute 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if(UtilTools.isNull(attrname)){
				logger.warn("入口参数错误。attributeName 为空。");
				return result;
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			String tmpKey = UtilTools.getTrim( config.getCode() );
			
			if( UtilTools.isNull(tmpKey) ){
				throw new Exception("Parameter 配置错误， 其中属性param 没有设置。");
			}

			String tmpattr = UtilTools.getTrim(attrname);
			
			result = tmpKey.equalsIgnoreCase(tmpattr);
			
			
			logger.debug("ParameterAttributeCognitron.getAttribute 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
}