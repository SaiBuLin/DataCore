package org.zml.data.vo.bind;
public class VISchema extends Schema
{
	private FormRelation formRelation;
	private Form form;
	public FormRelation getFormRelation()
	{
		return this.formRelation;
	}
	public void setFormRelation(FormRelation informRelation )
	{
		this.formRelation = informRelation;
	}
	public Form getForm()
	{
		return this.form;
	}
	public void setForm(Form inform )
	{
		this.form = inform;
	}
}