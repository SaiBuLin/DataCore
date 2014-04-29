package org.zml.data.vo.bind;
public class ViewForm extends ServiceForm
{
	private Right right;
	private Relation relation;
	private Left left;
	private TableRelation tableRelation;
	public Right getRight()
	{
		return this.right;
	}
	public void setRight(Right inright )
	{
		this.right = inright;
	}
	public Relation getRelation()
	{
		return this.relation;
	}
	public void setRelation(Relation inrelation )
	{
		this.relation = inrelation;
	}
	public Left getLeft()
	{
		return this.left;
	}
	public void setLeft(Left inleft )
	{
		this.left = inleft;
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