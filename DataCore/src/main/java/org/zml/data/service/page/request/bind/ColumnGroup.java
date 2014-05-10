package org.zml.data.service.page.request.bind;
import java.util.ArrayList;
public class ColumnGroup extends Column
{
	private ArrayList<Column> column = new ArrayList<Column>();
	public ArrayList<Column> getColumn()
	{
		return this.column;
	}
	public void setColumn(ArrayList<Column> incolumn )
	{
		this.column = incolumn;
	}
}