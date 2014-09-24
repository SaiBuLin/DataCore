package org.zml.form.bind;
public class DataForm extends Form
{
	private Section section;
	private FormService formService;
	public Section getSection()
	{
		return this.section;
	}
	public void setSection(Section insection )
	{
		this.section = insection;
	}
	public FormService getFormService()
	{
		return this.formService;
	}
	public void setFormService(FormService informService )
	{
		this.formService = informService;
	}
}