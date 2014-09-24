package org.zml.form.bind;
public class SQLFormService extends FormService
{
	private String sqlContent;
	public String getSqlContent()
	{
		return this.sqlContent;
	}
	public void setSqlContent(String insqlContent )
	{
		this.sqlContent = insqlContent;
	}
}