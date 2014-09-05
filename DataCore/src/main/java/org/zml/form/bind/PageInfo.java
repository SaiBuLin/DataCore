package org.zml.form.bind;
public class PageInfo extends FormNode
{
	private int page;
	private long records;
	private int pages;
	private int size;
	public int getPage()
	{
		return this.page;
	}
	public void setPage(int inpage )
	{
		this.page = inpage;
	}
	public long getRecords()
	{
		return this.records;
	}
	public void setRecords(long inrecords )
	{
		this.records = inrecords;
	}
	public int getPages()
	{
		return this.pages;
	}
	public void setPages(int inpages )
	{
		this.pages = inpages;
	}
	public int getSize()
	{
		return this.size;
	}
	public void setSize(int insize )
	{
		this.size = insize;
	}
}