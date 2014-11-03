package org.zml.schema.bind;
public class ServiceField extends Field
{
	private String field;
	private String format;
	private Library library;
	private int size;
	private DataType dataType;
	private Filter filter;
	public String getField()
	{
		return this.field;
	}
	public void setField(String infield )
	{
		this.field = infield;
	}
	public String getFormat()
	{
		return this.format;
	}
	public void setFormat(String informat )
	{
		this.format = informat;
	}
	public Library getLibrary()
	{
		return this.library;
	}
	public void setLibrary(Library inlibrary )
	{
		this.library = inlibrary;
	}
	public int getSize()
	{
		return this.size;
	}
	public void setSize(int insize )
	{
		this.size = insize;
	}
	public DataType getDataType()
	{
		return this.dataType;
	}
	public void setDataType(DataType indataType )
	{
		this.dataType = indataType;
	}
	public Filter getFilter()
	{
		return this.filter;
	}
	public void setFilter(Filter infilter )
	{
		this.filter = infilter;
	}
}