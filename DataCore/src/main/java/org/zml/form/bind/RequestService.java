package org.zml.form.bind;
public class RequestService extends QueryFormNode
{
	private FormSet formSet;
	public FormSet getFormSet()
	{
		return this.formSet;
	}
	public void setFormSet(FormSet informSet )
	{
		this.formSet = informSet;
	}
}