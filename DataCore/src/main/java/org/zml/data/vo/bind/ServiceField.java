package org.zml.data.vo.bind;
public class ServiceField extends Field
{
	private FieldValue fieldValue;
	private SQLFunction function;
	private Status status;
	private String label;
	private DataType dataType;
	private String format;
	private Boolean noneSelected;
	private int size;
	private String field;
	public FieldValue getFieldValue()
	{
		return this.fieldValue;
	}
	public void setFieldValue(FieldValue infieldValue )
	{
		this.fieldValue = infieldValue;
	}
	public SQLFunction getFunction()
	{
		return this.function;
	}
	public void setFunction(SQLFunction infunction )
	{
		this.function = infunction;
	}
	public Status getStatus()
	{
		return this.status;
	}
	public void setStatus(Status instatus )
	{
		this.status = instatus;
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
	public Boolean getNoneSelected()
	{
		return this.noneSelected;
	}
	public void setNoneSelected(Boolean innoneSelected )
	{
		this.noneSelected = innoneSelected;
	}
	public int getSize()
	{
		return this.size;
	}
	public void setSize(int insize )
	{
		this.size = insize;
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