package org.zml.data.vo.bind;
public class DataForm extends ServiceForm
{
	private DataSet dataSet;
	private Field field;
	public DataSet getDataSet()
	{
		return this.dataSet;
	}
	public void setDataSet(DataSet indataSet )
	{
		this.dataSet = indataSet;
	}
	public Field getField()
	{
		return this.field;
	}
	public void setField(Field infield )
	{
		this.field = infield;
	}
}