package org.zml.data.service.page.request.bind;
public class SQLSource extends PageDataSource
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