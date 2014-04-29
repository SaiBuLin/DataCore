package org.zml.data.vo.command.bind;
public class ServiceTask extends RequestTask
{
	private RequestParameter requestParameter;
	private String commandContent;
	public RequestParameter getRequestParameter()
	{
		return this.requestParameter;
	}
	public void setRequestParameter(RequestParameter inrequestParameter )
	{
		this.requestParameter = inrequestParameter;
	}
	public String getCommandContent()
	{
		return this.commandContent;
	}
	public void setCommandContent(String incommandContent )
	{
		this.commandContent = incommandContent;
	}
}