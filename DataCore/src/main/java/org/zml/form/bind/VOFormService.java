package org.zml.form.bind;
public class VOFormService extends FormService
{
	private String formcode;
	private String vocode;
	public String getFormcode()
	{
		return this.formcode;
	}
	public void setFormcode(String informcode )
	{
		this.formcode = informcode;
	}
	public String getVocode()
	{
		return this.vocode;
	}
	public void setVocode(String invocode )
	{
		this.vocode = invocode;
	}
}