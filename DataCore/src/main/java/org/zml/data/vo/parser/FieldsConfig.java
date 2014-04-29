package org.zml.data.vo.parser;

import java.util.HashMap;
import java.util.Map;

import org.zml.util.UtilTools;

public class FieldsConfig {
	Map<String, Object> selectFields = new HashMap<String,Object>();
	Map<String, Object> whereFields = new HashMap<String,Object>();
	Map<String, Object> orderFields = new HashMap<String,Object>();
	Map<String, Object> groupbyFields = new HashMap<String,Object>();
	
	public Map<String, Object> getSelectFields() {
		return selectFields;
	}
	
	public void setSelectFields(Map<String, Object> selectFields) {
		this.selectFields = selectFields;
	}
	
	public Map<String, Object> getWhereFields() {
		return whereFields;
	}
	
	public void setWhereFields(Map<String, Object> whereFields) {
		this.whereFields = whereFields;
	}
	
	public Map<String, Object> getOrderFields() {
		return orderFields;
	}
	
	public void setOrderFields(Map<String, Object> orderFields) {
		this.orderFields = orderFields;
	}
	
	public Map<String, Object> getGroupbyFields() {
		return groupbyFields;
	}
	
	public void setGroupbyFields(Map<String, Object> groupbyFields) {
		this.groupbyFields = groupbyFields;
	}
	
	public Object getField(String key){
		Object result = null;
		
		try{
			
			if(UtilTools.isNull(key)) return result;
			
			String tmpkey = UtilTools.getTrim( key );
			
			if( selectFields != null ){
				if( selectFields.containsKey(tmpkey)){
					return selectFields.get(tmpkey);
				}
			}
			
			if( whereFields != null ){
				if( whereFields.containsKey(tmpkey)){
					return whereFields.get(tmpkey);
				}
			}
			
			if( orderFields != null ){
				if( orderFields.containsKey(tmpkey)){
					return orderFields.get(tmpkey);
				}
			}
			
			if( groupbyFields != null ){
				if( groupbyFields.containsKey(tmpkey)){
					return groupbyFields.get(tmpkey);
				}
			}
			
			
			return result;
		}catch(Exception e){
			result = null;
		}
		
		return result;
	}
}
