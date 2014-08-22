package org.zml.schema.bind;
import java.util.ArrayList;
public class FieldGroup extends Field
{
	private ArrayList<Field> field = new ArrayList<Field>();
	public ArrayList<Field> getField()
	{
		return this.field;
	}
	public void setField(ArrayList<Field> infield )
	{
		this.field = infield;
	}
}