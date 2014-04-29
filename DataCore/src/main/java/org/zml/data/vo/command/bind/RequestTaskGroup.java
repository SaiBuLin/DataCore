package org.zml.data.vo.command.bind;
import java.util.ArrayList;
public class RequestTaskGroup extends RequestTask
{
	private ArrayList<RequestTask> requestTask = new ArrayList<RequestTask>();
	public ArrayList<RequestTask> getRequestTask()
	{
		return this.requestTask;
	}
	public void setRequestTask(ArrayList<RequestTask> inrequestTask )
	{
		this.requestTask = inrequestTask;
	}
}