package org.zml.data.vo.command.parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.RequestParameter;
import org.zml.data.vo.command.bind.RequestTask;
import org.zml.tools.xml.parser.CTXMLElement;

public abstract class SQLCommand implements SQLCommandAble
{
	protected static Logger logger = LogManager.getLogger("DataSerivce.vo.parser.v2013");
	
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
	public void addRequestTask(RequestTask task ) throws Exception{
		
	}
	
	@Override
	public void addRequestTask(CommandConfiguration config ) throws Exception{
		
	}
	
	@Override
	public Map<Integer, RequestTask> getRequestTask() throws Exception{
		return null;
	}
	
	@Override
	public RequestTask getRequestTaskByCode(String code) throws Exception{
		return null;
	}
	
	@Override
	public void removeRequestTaskBy(String code) throws Exception{
		
	}
	
	@Override
	public RequestTask indexRequestTask(int index) throws Exception{
		return null;
	}
	
	@Override
	public String getRequestTaskContent() throws Exception{
		return "";
	}
	
	@Override
	public String getRequestTaskContent(int index)throws Exception{
		return "";
	}
	
	@Override
	public String getRequestTaskContent(String code)throws Exception{
		return "";
	}
	
	@Override
	public void insertRequestTask(String code, String commandString )throws Exception{
		
	}
	
	@Override
	public void addParameter( RequestParameter parameter ) throws Exception{
		
	}
	
	@Override
	public List<RequestParameter> getParameters() throws Exception{
		return new ArrayList<RequestParameter>();
	}
}