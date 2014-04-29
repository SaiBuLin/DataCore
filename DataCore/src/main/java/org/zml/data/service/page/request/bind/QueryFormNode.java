package org.zml.data.service.page.request.bind;
import org.zml.tools.xml.parser.*;
public class QueryFormNode extends CTXMLElement
{
	private int index;
	private String code;
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
}