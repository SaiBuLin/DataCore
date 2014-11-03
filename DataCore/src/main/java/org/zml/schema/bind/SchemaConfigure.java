package org.zml.schema.bind;
public class SchemaConfigure extends SchemaDefine
{
	private Factory factory;
	private Service service;
	private Schema schema;
	public Factory getFactory()
	{
		return this.factory;
	}
	public void setFactory(Factory infactory )
	{
		this.factory = infactory;
	}
	public Service getService()
	{
		return this.service;
	}
	public void setService(Service inservice )
	{
		this.service = inservice;
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