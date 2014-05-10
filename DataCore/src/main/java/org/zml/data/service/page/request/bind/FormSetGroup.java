package org.zml.data.service.page.request.bind;
import java.util.ArrayList;
public class FormSetGroup extends FormSet
{
	private ArrayList<FormSet> formSet = new ArrayList<FormSet>();
	public ArrayList<FormSet> getFormSet()
	{
		return this.formSet;
	}
	public void setFormSet(ArrayList<FormSet> informSet )
	{
		this.formSet = informSet;
	}
}