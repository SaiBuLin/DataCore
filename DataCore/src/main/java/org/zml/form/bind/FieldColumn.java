package org.zml.form.bind;
public class FieldColumn extends Column
{
	private String content;
	private String field;
	public String getContent()
	{
		return this.content;
	}
	public void setContent(String incontent )
	{
		this.content = incontent;
	}
	public String getField()
	{
		return this.field;
	}
	public void setField(String infield )
	{
		this.field = infield;
	}
}