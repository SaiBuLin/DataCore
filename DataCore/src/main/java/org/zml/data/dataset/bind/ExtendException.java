package org.zml.data.dataset.bind;
public class ExtendException extends DataException
{
	private String errortime;
	private int errorcode;
	private String errormessage;
	private String errorreason;
	public String getErrortime()
	{
		return this.errortime;
	}
	public void setErrortime(String inerrortime )
	{
		this.errortime = inerrortime;
	}
	public int getErrorcode()
	{
		return this.errorcode;
	}
	public void setErrorcode(int inerrorcode )
	{
		this.errorcode = inerrorcode;
	}
	public String getErrormessage()
	{
		return this.errormessage;
	}
	public void setErrormessage(String inerrormessage )
	{
		this.errormessage = inerrormessage;
	}
	public String getErrorreason()
	{
		return this.errorreason;
	}
	public void setErrorreason(String inerrorreason )
	{
		this.errorreason = inerrorreason;
	}
}