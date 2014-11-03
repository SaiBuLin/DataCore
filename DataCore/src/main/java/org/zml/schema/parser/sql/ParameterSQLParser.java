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
	 * �������ֵ
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAttributes() throws Exception{
		Map<String, Object> result = new HashMap<String,Object>();
		try{
			logger.debug("ParameterAttributeCognitron.getAttributes ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			String tmpKey = UtilTools.getTrim( config.getCode() );
			
			if( UtilTools.isNull(tmpKey )){
				throw new Exception(" Parameter ���ô���û������param. ");
			}
			
			result.put(tmpKey, config.getValue() );
			
			logger.debug("ParameterAttributeCognitron.getAttributes ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * ����attr Name ���ֵ�б�
	 * @param attrname
	 * @return
	 * @throws Exception
	 */
	public List<Object> getAttribute(String attrname ) throws Exception{
		List<Object> result = new ArrayList<Object>();
		try{
			logger.debug("ParameterAttributeCognitron.getAttribute ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			String tmpKey = UtilTools.getTrim( config.getCode() );
			
			if( UtilTools.isNull(tmpKey )){
				throw new Exception(" Parameter ���ô���û������param. ");
			}
			
			if( this.isMine(attrname)){
			
				result.add( config.getValue() );
			}
			
			logger.debug("ParameterAttributeCognitron.getAttribute ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * ������������ֵ
	 * @param attrname
	 * @param value
	 * @throws Exception
	 */
	public void setAttribute(String attrname, Object value) throws Exception{
		try{
			logger.debug("ParameterAttributeCognitron.getAttribute ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			String tmpKey = UtilTools.getTrim( config.getCode() );
			
			if( UtilTools.isNull(tmpKey )){
				throw new Exception(" Parameter ���ô���û������param. ");
			}
			
			if( this.isMine(attrname)){
				config.setValue(String.valueOf(value) );
				
			}
			
			logger.debug("ParameterAttributeCognitron.getAttribute ������ϡ�");
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * �ж��Ƿ����Լ�
	 * @param attrname
	 * @throws Exception
	 */
	public boolean isMine(String attrname) throws Exception{
		boolean result = false;
		try{
			logger.debug("ParameterAttributeCognitron.getAttribute ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if(UtilTools.isNull(attrname)){
				logger.warn("��ڲ�������attributeName Ϊ�ա�");
				return result;
			}
			
			Parameter config = (Parameter)this.queryDefineElement;
			
			String tmpKey = UtilTools.getTrim( config.getCode() );
			
			if( UtilTools.isNull(tmpKey) ){
				throw new Exception("Parameter ���ô��� ��������param û�����á�");
			}

			String tmpattr = UtilTools.getTrim(attrname);
			
			result = tmpKey.equalsIgnoreCase(tmpattr);
			
			
			logger.debug("ParameterAttributeCognitron.getAttribute ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
}