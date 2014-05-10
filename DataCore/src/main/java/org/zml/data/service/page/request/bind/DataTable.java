package org.zml.data.service.page.request.bind;
public class DataTable extends FormSet
{
	private DataSource dataSource;
	private Section section;
	public DataSource getDataSource()
	{
		return this.dataSource;
	}
	public void setDataSource(DataSource indataSource )
	{
		this.dataSource = indataSource;
	}
	public Section getSection()
	{
		return this.section;
	}
	public void setSection(Section insection )
	{
		this.section = insection;
	}
}