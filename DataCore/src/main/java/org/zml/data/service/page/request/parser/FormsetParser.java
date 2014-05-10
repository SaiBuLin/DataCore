package org.zml.data.service.page.request.parser;
import org.zml.tools.xml.parser.CTXMLElement;
public abstract class FormsetParser implements FormsetParserAble
{
	protected CTXMLElement queryDefineElement = null;
	public CTXMLElement getQueryDefineElement()
	{
		return queryDefineElement;
	}
	public void setQueryDefineElement(CTXMLElement queryDefineElement)
	{
		this.queryDefineElement = queryDefineElement;
	}
}