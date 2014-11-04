package org.zml.data;

import java.util.ArrayList;
import java.util.List;

public class SQLString {
	private String sqlString = "";
	private List<SQLParameter> parameters = new ArrayList<SQLParameter>();
	
	public String getSqlString() {
		return sqlString;
	}
	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}
	public List<SQLParameter> getParameters() {
		return parameters;
	}
	public void setParameters(List<SQLParameter> parameters) {
		this.parameters = parameters;
	}
	
	
}
