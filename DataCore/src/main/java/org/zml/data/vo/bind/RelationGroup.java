package org.zml.data.vo.bind;
import java.util.ArrayList;
public class RelationGroup extends Relation
{
	private ArrayList<Relation> relation = new ArrayList<Relation>();
	private OperationLogical reloperation;
	public ArrayList<Relation> getRelation()
	{
		return this.relation;
	}
	public void setRelation(ArrayList<Relation> inrelation )
	{
		this.relation = inrelation;
	}
	public OperationLogical getReloperation()
	{
		return this.reloperation;
	}
	public void setReloperation(OperationLogical inreloperation )
	{
		this.reloperation = inreloperation;
	}
}