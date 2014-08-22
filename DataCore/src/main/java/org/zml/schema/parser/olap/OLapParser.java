package org.zml.schema.parser.olap;
import org.zml.tools.xml.parser.CTXMLElement;
public abstract class OLapParser implements OLapParserAble
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