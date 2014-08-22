package org.zml.schema.bind;
import java.util.ArrayList;
public class RelationGroup extends Relation
{
	private ArrayList<Relation> relation = new ArrayList<Relation>();
	public ArrayList<Relation> getRelation()
	{
		return this.relation;
	}
	public void setRelation(ArrayList<Relation> inrelation )
	{
		this.relation = inrelation;
	}
}