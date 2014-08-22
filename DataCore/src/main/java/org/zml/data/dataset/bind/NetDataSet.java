package org.zml.data.dataset.bind;
public class NetDataSet extends DatasetNode
{
	private DataTable dataTable;
	private DataException dataException;
	private int updatenumber;
	public DataTable getDataTable()
	{
		return this.dataTable;
	}
	public void setDataTable(DataTable indataTable )
	{
		this.dataTable = indataTable;
	}
	public DataException getDataException()
	{
		return this.dataException;
	}
	public void setDataException(DataException indataException )
	{
		this.dataException = indataException;
	}
	public int getUpdatenumber()
	{
		return this.updatenumber;
	}
	public void setUpdatenumber(int inupdatenumber )
	{
		this.updatenumber = inupdatenumber;
	}
}