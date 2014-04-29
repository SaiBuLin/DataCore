package org.zml.data.vo.bind;
public class JNDIConnection extends Connection
{
	private String jndi;
	private String context;
	public String getJndi()
	{
		return this.jndi;
	}
	public void setJndi(String injndi )
	{
		this.jndi = injndi;
	}
	public String getContext()
	{
		return this.context;
	}
	public void setContext(String incontext )
	{
		this.context = incontext;
	}
}