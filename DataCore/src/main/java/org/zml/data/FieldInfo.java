package org.zml.data;



public class FieldInfo {
	private String field;
	private String extendString;	
	private SQLParameter parameter ;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getExtendString() {
		return extendString;
	}
	public void setExtendString(String extendString) {
		this.extendString = extendString;
	}
	public SQLParameter getParameter() {
		return parameter;
	}
	public void setParameter(SQLParameter parameter) {
		this.parameter = parameter;
	}
}
