package org.zml.schema.parser.esri.version10;
import org.zml.tools.xml.parser.CTXMLElement;
public abstract class ArcGISParser implements ArcGISParserAble
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