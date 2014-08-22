package org.zml.schema.bind;
public class FormLibrary extends Library
{
	private String valuefield;
	private String codefield;
	private Form form;
	public String getValuefield()
	{
		return this.valuefield;
	}
	public void setValuefield(String invaluefield )
	{
		this.valuefield = invaluefield;
	}
	public String getCodefield()
	{
		return this.codefield;
	}
	public void setCodefield(String incodefield )
	{
		this.codefield = incodefield;
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