package org.zml.data.vo.bind;
import java.util.ArrayList;
public class FormRelationGroup extends FormRelation
{
	private ArrayList<FormRelation> formRelation = new ArrayList<FormRelation>();
	public ArrayList<FormRelation> getFormRelation()
	{
		return this.formRelation;
	}
	public void setFormRelation(ArrayList<FormRelation> informRelation )
	{
		this.formRelation = informRelation;
	}
}