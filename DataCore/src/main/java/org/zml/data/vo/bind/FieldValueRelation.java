package org.zml.data.vo.bind;
public class FieldValueRelation extends Relation
{
	private String value;
	private FieldLogical operation;
	private String field;
	public String getValue()
	{
		return this.value;
	}
	public void setValue(String invalue )
	{
		this.value = invalue;
	}
	public FieldLogical getOperation()
	{
		return this.operation;
	}
	public void setOperation(FieldLogical inoperation )
	{
		this.operation = inoperation;
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