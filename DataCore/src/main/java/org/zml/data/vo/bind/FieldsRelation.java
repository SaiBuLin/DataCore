package org.zml.data.vo.bind;
public class FieldsRelation extends Relation
{
	private String leftfield;
	private String rightfield;
	private FieldLogical operation;
	public String getLeftfield()
	{
		return this.leftfield;
	}
	public void setLeftfield(String inleftfield )
	{
		this.leftfield = inleftfield;
	}
	public String getRightfield()
	{
		return this.rightfield;
	}
	public void setRightfield(String inrightfield )
	{
		this.rightfield = inrightfield;
	}
	public FieldLogical getOperation()
	{
		return this.operation;
	}
	public void setOperation(FieldLogical inoperation )
	{
		this.operation = inoperation;
	}
}