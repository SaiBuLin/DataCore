package org.zml.data.vo.bind;
public class FieldValueRelation extends Relation
{
	private FieldLogical operation;
	private String value;
	private String field;
	public FieldLogical getOperation()
	{
		return this.operation;
	}
	public void setOperation(FieldLogical inoperation )
	{
		this.operation = inoperation;
	}
	public String getValue()
	{
		return this.value;
	}
	public void setValue(String invalue )
	{
		this.value = invalue;
	}
	public String getField()
	{
		return this.field;
	}
	public void setField(String infield )
	{
		this.field = infield;
	}
}