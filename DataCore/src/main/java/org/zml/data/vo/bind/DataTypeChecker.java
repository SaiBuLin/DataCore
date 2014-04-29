package org.zml.data.vo.bind;
public class DataTypeChecker extends Validator
{
	private DataType datatype;
	public DataType getDatatype()
	{
		return this.datatype;
	}
	public void setDatatype(DataType indatatype )
	{
		this.datatype = indatatype;
	}
}