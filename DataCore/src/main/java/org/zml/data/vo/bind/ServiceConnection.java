package org.zml.data.vo.bind;
public class ServiceConnection extends Connection
{
	private String serviceurl;
	public String getServiceurl()
	{
		return this.serviceurl;
	}
	public void setServiceurl(String inserviceurl )
	{
		this.serviceurl = inserviceurl;
	}
}