package org.zml.schema.bind;
public class ViewRelation extends Relation
{
	private String right;
	private Express express;
	private String left;
	public String getRight()
	{
		return this.right;
	}
	public void setRight(String inright )
	{
		this.right = inright;
	}
	public Express getExpress()
	{
		return this.express;
	}
	public void setExpress(Express inexpress )
	{
		this.express = inexpress;
	}
	public String getLeft()
	{
		return this.left;
	}
	public void setLeft(String inleft )
	{
		this.left = inleft;
	}
}