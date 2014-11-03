package org.zml.schema.parser.olap;
import org.zml.data.DataServiceTools;
import org.zml.tools.xml.parser.CTXMLElement;
public abstract class OlapParser extends DataServiceTools implements OlapParserAble
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