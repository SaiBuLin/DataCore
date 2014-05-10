package org.zml.data.service.page.request.bind;
public class PageDataSource extends DataSource
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