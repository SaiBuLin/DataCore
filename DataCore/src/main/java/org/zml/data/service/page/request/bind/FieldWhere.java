package org.zml.data.service.page.request.bind;
public class FieldWhere extends ConditionSyntax
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