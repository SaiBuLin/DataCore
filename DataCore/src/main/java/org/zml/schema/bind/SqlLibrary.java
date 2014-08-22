package org.zml.schema.bind;
public class SqlLibrary extends Library
{
	private String valuefield;
	private String codefield;
	private String sqlcontent;
	public String getValuefield()
	{
		return this.valuefield;
	}
	public void setValuefield(String invaluefield )
	{
		this.valuefield = invaluefield;
	}
	public String getCodefield()
	{
		return this.codefield;
	}
	public void setCodefield(String incodefield )
	{
		this.codefield = incodefield;
	}
	public String getSqlcontent()
	{
		return this.sqlcontent;
	}
	public void setSqlcontent(String insqlcontent )
	{
		this.sqlcontent = insqlcontent;
	}
}