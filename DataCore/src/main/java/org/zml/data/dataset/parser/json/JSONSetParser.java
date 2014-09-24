package org.zml.data.dataset.parser.json;
import org.zml.data.DataServiceTools;
import org.zml.tools.xml.parser.CTXMLElement;

/**
 * ��DataService ת����JSON ��ʽ
 * @author zlmwork
 *
 */
public abstract class JSONSetParser extends DataServiceTools implements JSONSetParserAble
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