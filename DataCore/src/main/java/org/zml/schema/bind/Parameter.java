package org.zml.schema.bind;
public class Parameter extends Attribute
{
	private String value;
	private DataType datatype;
	public String getValue()
	{
		return this.value;
	}
	public void setValue(String invalue )
	{
		this.value = invalue;
	}
	public DataType getDatatype()
	{
		return this.datatype;
	}
	public void setDatatype(DataType indatatype )
	{
		this.datatype = indatatype;
	}
}