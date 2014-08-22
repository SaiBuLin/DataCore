package org.zml.data.dataset.bind;
public class DataTable extends Table
{
	private DataField dataField;
	private long page;
	private MyValue myValue;
	private long records;
	private long pages;
	private String name;
	private long pagesize;
	public DataField getDataField()
	{
		return this.dataField;
	}
	public void setDataField(DataField indataField )
	{
		this.dataField = indataField;
	}
	public long getPage()
	{
		return this.page;
	}
	public void setPage(long inpage )
	{
		this.page = inpage;
	}
	public MyValue getMyValue()
	{
		return this.myValue;
	}
	public void setMyValue(MyValue inmyValue )
	{
		this.myValue = inmyValue;
	}
	public long getRecords()
	{
		return this.records;
	}
	public void setRecords(long inrecords )
	{
		this.records = inrecords;
	}
	public long getPages()
	{
		return this.pages;
	}
	public void setPages(long inpages )
	{
		this.pages = inpages;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String inname )
	{
		this.name = inname;
	}
	public long getPagesize()
	{
		return this.pagesize;
	}
	public void setPagesize(long inpagesize )
	{
		this.pagesize = inpagesize;
	}
}