package org.zml.data.vo.bind;
public class ServiceActionTools extends FunctionTools
{
	private Connection connection;
	public Connection getConnection()
	{
		return this.connection;
	}
	public void setConnection(Connection inconnection )
	{
		this.connection = inconnection;
	}
}