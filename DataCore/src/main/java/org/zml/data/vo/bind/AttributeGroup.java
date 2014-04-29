package org.zml.data.vo.bind;
import java.util.ArrayList;
public class AttributeGroup extends Attribute
{
	private ArrayList<Attribute> attribute = new ArrayList<Attribute>();
	public ArrayList<Attribute> getAttribute()
	{
		return this.attribute;
	}
	public void setAttribute(ArrayList<Attribute> inattribute )
	{
		this.attribute = inattribute;
	}
}