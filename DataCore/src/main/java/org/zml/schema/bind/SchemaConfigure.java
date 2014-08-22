package org.zml.schema.bind;
public class SchemaConfigure extends SchemaDefine
{
	private Factory factory;
	private Schema schema;
	public Factory getFactory()
	{
		return this.factory;
	}
	public void setFactory(Factory infactory )
	{
		this.factory = infactory;
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