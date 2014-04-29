package org.zml.data.vo.command.bind;
public class CommandConfiguration extends CommandDefine
{
	private RequestTask requestTask;
	public RequestTask getRequestTask()
	{
		return this.requestTask;
	}
	public void setRequestTask(RequestTask inrequestTask )
	{
		this.requestTask = inrequestTask;
	}
}