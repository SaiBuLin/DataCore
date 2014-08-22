package org.zml.schema.bind;
public class FieldsExpress extends Express
{
	private FieldLogical operationship;
	private String rightField;
	private String leftField;
	public FieldLogical getOperationship()
	{
		return this.operationship;
	}
	public void setOperationship(FieldLogical inoperationship )
	{
		this.operationship = inoperationship;
	}
	public String getRightField()
	{
		return this.rightField;
	}
	public void setRightField(String inrightField )
	{
		this.rightField = inrightField;
	}
	public String getLeftField()
	{
		return this.leftField;
	}
	public void setLeftField(String inleftField )
	{
		this.leftField = inleftField;
	}
}