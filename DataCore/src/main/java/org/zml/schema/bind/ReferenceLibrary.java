package org.zml.schema.bind;
public class ReferenceLibrary extends Library
{
	private String valuefield;
	private String codefield;
	private String formCode;
	private String voCode;
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
	public String getFormCode()
	{
		return this.formCode;
	}
	public void setFormCode(String informCode )
	{
		this.formCode = informCode;
	}
	public String getVoCode()
	{
		return this.voCode;
	}
	public void setVoCode(String invoCode )
	{
		this.voCode = invoCode;
	}
}