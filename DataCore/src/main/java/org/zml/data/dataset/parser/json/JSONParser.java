package org.zml.data.dataset.parser.json;
import org.zml.tools.xml.parser.CTXMLElement;
public abstract class JSONParser implements JSONParserAble
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