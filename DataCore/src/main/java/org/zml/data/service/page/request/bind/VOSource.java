package org.zml.data.service.page.request.bind;
public class VOSource extends PageDataSource
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