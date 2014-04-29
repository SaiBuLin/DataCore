package org.zml.data.service.page.request.bind;
import java.util.ArrayList;
public class RequestFieldGroup extends RequestField
{
	private ArrayList<RequestField> requestField = new ArrayList<RequestField>();
	public ArrayList<RequestField> getRequestField()
	{
		return this.requestField;
	}
	public void setRequestField(ArrayList<RequestField> inrequestField )
	{
		this.requestField = inrequestField;
	}
}