package org.zml.data.dataset.bind;

import org.zml.data.vo.bind.DataType;

public class ColumnField extends DataField
{
	private int fieldsize;
	private String field;
	private DataType datatype;
	private String label;
	public int getFieldsize()
	{
		return this.fieldsize;
	}
	public void setFieldsize(int infieldsize )
	{
		this.fieldsize = infieldsize;
	}
	public String getField()
	{
		return this.field;
	}
	public void setField(String infield )
	{
		this.field = infield;
	}
	public DataType getDatatype()
	{
		return this.datatype;
	}
	public void setDatatype( DataType indatatype )
	{
		this.datatype = indatatype;
	}
	public String getLabel()
	{
		return this.label;
	}
	public void setLabel(String inlabel )
	{
		this.label = inlabel;
	}
}