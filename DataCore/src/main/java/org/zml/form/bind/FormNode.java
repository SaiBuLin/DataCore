package org.zml.form.bind;
import org.zml.tools.xml.parser.*;
public class FormNode extends CTXMLElement
{
	private int index;
	private String code;
	private String alias;
	public int getIndex()
	{
		return this.index;
	}
	public void setIndex(int inindex )
	{
		this.index = inindex;
	}
	public String getCode()
	{
		return this.code;
	}
	public void setCode(String incode )
	{
		this.code = incode;
	}
	public String getAlias()
	{
		return this.alias;
	}
	public void setAlias(String inalias )
	{
		this.alias = inalias;
	}
}