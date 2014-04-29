package org.zml.data.vo.command.bind;
import java.util.ArrayList;
public class RequestParameterGroup extends RequestParameter
{
	private ArrayList<RequestParameter> requestParameter = new ArrayList<RequestParameter>();
	public ArrayList<RequestParameter> getRequestParameter()
	{
		return this.requestParameter;
	}
	public void setRequestParameter(ArrayList<RequestParameter> inrequestParameter )
	{
		this.requestParameter = inrequestParameter;
	}
}