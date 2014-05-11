package org.zml.data.vo.bind;
public class FormsRelation extends FormRelation
{
	private String leftform;
	private Relation relation;
	private TableRelation tableRelation;
	private String rightform;
	public String getLeftform()
	{
		return this.leftform;
	}
	public void setLeftform(String inleftform )
	{
		this.leftform = inleftform;
	}
	public Relation getRelation()
	{
		return this.relation;
	}
	public void setRelation(Relation inrelation )
	{
		this.relation = inrelation;
	}
	public TableRelation getTableRelation()
	{
		return this.tableRelation;
	}
	public void setTableRelation(TableRelation intableRelation )
	{
		this.tableRelation = intableRelation;
	}
	public String getRightform()
	{
		return this.rightform;
	}
	public void setRightform(String inrightform )
	{
		this.rightform = inrightform;
	}
}