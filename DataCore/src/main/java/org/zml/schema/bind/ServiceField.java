package org.zml.schema.bind;
public class ServiceField extends Field
{
	private Library library;
	private String alias;
	private String label;
	private DataType dataType;
	private String format;
	private int size;
	private Filter filter;
	private String field;
	public Library getLibrary()
	{
		return this.library;
	}
	public void setLibrary(Library inlibrary )
	{
		this.library = inlibrary;
	}
	public String getAlias()
	{
		return this.alias;
	}
	public void setAlias(String inalias )
	{
		this.alias = inalias;
	}
	public String getLabel()
	{
		return this.label;
	}
	public void setLabel(String inlabel )
	{
		this.label = inlabel;
	}
	public DataType getDataType()
	{
		return this.dataType;
	}
	public void setDataType(DataType indataType )
	{
		this.dataType = indataType;
	}
	public String getFormat()
	{
		return this.format;
	}
	public void setFormat(String informat )
	{
		this.format = informat;
	}
	public int getSize()
	{
		return this.size;
	}
	public void setSize(int insize )
	{
		this.size = insize;
	}
	public Filter getFilter()
	{
		return this.filter;
	}
	public void setFilter(Filter infilter )
	{
		this.filter = infilter;
	}
	public String getField()
	{
		return this.field;
	}
	public void setField(String infield )
	{
		this.field = infield;
	}
}