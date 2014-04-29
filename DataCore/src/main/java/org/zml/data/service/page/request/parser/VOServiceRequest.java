package org.zml.data.service.page.request.parser;

import org.zml.data.service.page.request.bind.RequestField;
import org.zml.data.vo.form.VOForm;
import org.zml.tools.xml.parser.CTXMLElement;

public abstract class VOServiceRequest implements VOServiceRequestAble
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
	
	@Override
	public RequestField getSelectedField(String code)throws Exception{
		return null;
	}
	
	@Override
	public RequestField getWhereField(String code)throws Exception{
		return null;
	}
	
	@Override
	public RequestField getOrderByField(String code)throws Exception{
		return null;
	}
	
	@Override
	public RequestField getGroupbyField(String code)throws Exception{
		return null;
	}
	
	@Override
	public String parseWhereForSyntax(VOForm form, String alias, String[] fields) throws Exception{
		return "";
	}
}