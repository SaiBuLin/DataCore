package org.zml.schema.parser.sql;

import org.zml.schema.bind.Field;

public class FieldInfo {
	private Field field;
	private String extendString;
	
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public String getExtendString() {
		return extendString;
	}
	public void setExtendString(String extendString) {
		this.extendString = extendString;
	}
	
	
}
