package org.zml.data.vo.bind;
public class DataForm extends ServiceForm
{
	private FormPart formPart;
	private DataSet dataSet;
	public FormPart getFormPart()
	{
		return this.formPart;
	}
	public void setFormPart(FormPart informPart )
	{
		this.formPart = informPart;
	}
	public DataSet getDataSet()
	{
		return this.dataSet;
	}
	public void setDataSet(DataSet indataSet )
	{
		this.dataSet = indataSet;
	}
}