package org.zml.schema.bind;
import java.util.ArrayList;
public class Transaction extends Schema
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