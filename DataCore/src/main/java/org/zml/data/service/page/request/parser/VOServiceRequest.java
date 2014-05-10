package org.zml.data.service.page.request.parser;

import java.util.List;

import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.RequestTask;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.vo.AIVOEngine;

public abstract class VOServiceRequest extends AIVOEngine implements VOServiceRequestAble
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
	public List<String> listSelectFieldNames() throws Exception {
		
		return null;
	}

	@Override
	public List<String> listWhereFieldNames() throws Exception {
		
		return null;
	}

	@Override
	public List<String> listOrderByFieldNames() throws Exception {
		
		return null;
	}

	@Override
	public List<String> listGroupByFieldNames() throws Exception {
		
		return null;
	}

	@Override
	public CommandConfiguration parseWhereForSyntax(RequestTask whereField,
			String alias) throws Exception {
		
		return null;
	}
	
	
}