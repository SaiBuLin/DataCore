package org.zml.schema.parser.sql;

import org.zml.schema.bind.DataType;

public class SQLParameter {
	private int index = 0;
	private DataType dataType ;
	private String value = "";
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public DataType getDataType() {
		return dataType;
	}
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
