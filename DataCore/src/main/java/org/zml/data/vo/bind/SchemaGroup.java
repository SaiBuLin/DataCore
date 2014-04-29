package org.zml.data.vo.bind;
import java.util.ArrayList;
public class SchemaGroup extends Schema
{
	private ArrayList<Schema> schema = new ArrayList<Schema>();
	public ArrayList<Schema> getSchema()
	{
		return this.schema;
	}
	public void setSchema(ArrayList<Schema> inschema )
	{
		this.schema = inschema;
	}
}