package org.zml.form.parser;
import org.zml.data.DataServiceTools;
import org.zml.tools.xml.parser.CTXMLElement;


public abstract class DemandForm extends DataServiceTools  implements DemandFormAble
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