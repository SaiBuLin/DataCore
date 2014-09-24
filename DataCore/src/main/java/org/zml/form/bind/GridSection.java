package org.zml.form.bind;
public class GridSection extends ColumnSection
{
	private PageInfo pageInfo;
	public PageInfo getPageInfo()
	{
		return this.pageInfo;
	}
	public void setPageInfo(PageInfo inpageInfo )
	{
		this.pageInfo = inpageInfo;
	}
}