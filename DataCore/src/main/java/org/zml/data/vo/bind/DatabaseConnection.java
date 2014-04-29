package org.zml.data.vo.bind;
public class DatabaseConnection extends Connection
{
	private String connectionString;
	public String getConnectionString()
	{
		return this.connectionString;
	}
	public void setConnectionString(String inconnectionString )
	{
		this.connectionString = inconnectionString;
	}
}