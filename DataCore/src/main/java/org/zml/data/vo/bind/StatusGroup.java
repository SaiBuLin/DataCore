package org.zml.data.vo.bind;
import java.util.ArrayList;
public class StatusGroup extends Status
{
	private ArrayList<Status> status = new ArrayList<Status>();
	public ArrayList<Status> getStatus()
	{
		return this.status;
	}
	public void setStatus(ArrayList<Status> instatus )
	{
		this.status = instatus;
	}
}