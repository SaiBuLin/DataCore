package org.zml.form.bind;
public class ColumnSection extends Section
{
	private Column column;
	public Column getColumn()
	{
		return this.column;
	}
	public void setColumn(Column incolumn )
	{
		this.column = incolumn;
	}
}