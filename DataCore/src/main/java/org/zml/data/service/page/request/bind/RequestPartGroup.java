package org.zml.data.service.page.request.bind;
import java.util.ArrayList;
public class RequestPartGroup extends RequestPart
{
	private ArrayList<RequestPart> requestPart = new ArrayList<RequestPart>();
	public ArrayList<RequestPart> getRequestPart()
	{
		return this.requestPart;
	}
	public void setRequestPart(ArrayList<RequestPart> inrequestPart )
	{
		this.requestPart = inrequestPart;
	}
}