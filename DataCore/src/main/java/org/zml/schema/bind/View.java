package org.zml.schema.bind;
public class View extends Schema
{
	private Relation relation;
	private String alias;
	private Schema schema;
	public Relation getRelation()
	{
		return this.relation;
	}
	public void setRelation(Relation inrelation )
	{
		this.relation = inrelation;
	}
	public String getAlias()
	{
		return this.alias;
	}
	public void setAlias(String inalias )
	{
		this.alias = inalias;
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