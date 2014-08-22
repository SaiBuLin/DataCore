package org.zml.data.dataset.bind;
import java.util.ArrayList;
public class TableGroup extends Table
{
	private ArrayList<DataTable> dataTable = new ArrayList<DataTable>();
	public ArrayList<DataTable> getDataTable()
	{
		return this.dataTable;
	}
	public void setDataTable(ArrayList<DataTable> indataTable )
	{
		this.dataTable = indataTable;
	}
}