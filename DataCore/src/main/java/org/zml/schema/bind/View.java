package org.zml.schema.bind;
public class View extends Schema
{
	private Relation relation;
	private Schema schema;
	public Relation getRelation()
	{
		return this.relation;
	}
	public void setRelation(Relation inrelation )
	{
		this.relation = inrelation;
	}
	public Schema getSchema()
	{
		return this.schema;
	}
	public void setSchema(Schema inschema )
	{
		this.schema = inschema;
	}
}