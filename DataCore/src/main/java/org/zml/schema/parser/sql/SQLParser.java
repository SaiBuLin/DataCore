package org.zml.schema.parser.sql;
import org.zml.data.DataServiceTools;
import org.zml.tools.xml.parser.CTXMLElement;

public abstract class SQLParser extends DataServiceTools implements SQLParserAble
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