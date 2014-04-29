package org.zml.data.vo.form;

import java.util.Map;
import java.util.HashMap;

import org.zml.util.UtilTools;
import org.zml.data.service.page.request.bind.QueryRequest;
import org.zml.data.vo.tools.action.IActionTools;

/**
 * 
 * @author zlmwork
 * 属性集合propeties的Key 区分大小写
 */
public class VOForm {
	Map<String,Object> properties = new HashMap<String,Object>();
	
	QueryRequest MyQueryRequest = null;
	
	IActionTools formActionTools = null;
	
	public VOForm(){
		if( properties == null ){
			properties = new HashMap<String,Object>();
		}
	}
	
	public Map<String,Object> getProperties(){
		
		return this.properties;
	}
	
	public void putProperty(String key, Object value){
		if( value == null)return;
		if(UtilTools.isNull(key))return;
		
		if(properties == null)return;
		
		String tmpKey = UtilTools.getTrim(key);
		
		properties.put(tmpKey, value);
	}
	
	public Object getProperty(String key){
		Object result = null;
		
		if(UtilTools.isNull(key))return result;
		String tmpKey = UtilTools.getTrim(key);
		
		if(properties.containsKey(tmpKey)){
			result = properties.get(tmpKey);
		}
		return result;
	}
	
	public void clear(){
		if(this.properties != null ){
			this.properties.clear();
		}
	}
	
	public void remove(String key){
		if(UtilTools.isNull(key))return ;
		String tmpKey = UtilTools.getTrim(key);
		
		if(properties.containsKey(tmpKey)){
			properties.remove(tmpKey);
		}
	}

	public QueryRequest getQueryRequestService(){
		return this.MyQueryRequest;
	}
	
	public void setQueryRequestService( QueryRequest inQueryRequest){
		this.MyQueryRequest = inQueryRequest;
	}

	public IActionTools getFormActionTools() {
		return formActionTools;
	}

	public void setFormActionTools( IActionTools formActionTools ) {
		this.formActionTools = formActionTools;
	}
	
}
