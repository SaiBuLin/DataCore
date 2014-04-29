package org.zml.data.service.page.request.bind;
public class RequestColumn extends RequestPart
{
	private RequestField requestField;
	public RequestField getRequestField()
	{
		return this.requestField;
	}
	public void setRequestField(RequestField inrequestField )
	{
		this.requestField = inrequestField;
	}
}