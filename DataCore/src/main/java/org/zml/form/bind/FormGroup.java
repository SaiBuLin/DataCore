package org.zml.form.bind;
import java.util.ArrayList;
public class FormGroup extends Form
{
	private ArrayList<Form> form = new ArrayList<Form>();
	public ArrayList<Form> getForm()
	{
		return this.form;
	}
	public void setForm(ArrayList<Form> inform )
	{
		this.form = inform;
	}
}