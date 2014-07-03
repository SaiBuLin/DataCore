package org.zml.data.vo.bind;
public class BoundaryRelation extends Relation
{
	private Boundary boundary;
	private TableRelation tableRelation;
	public Boundary getBoundary()
	{
		return this.boundary;
	}
	public void setBoundary(Boundary inboundary )
	{
		this.boundary = inboundary;
	}
	public TableRelation getTableRelation()
	{
		return this.tableRelation;
	}
	public void setTableRelation(TableRelation intableRelation )
	{
		this.tableRelation = intableRelation;
	}
}