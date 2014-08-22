package org.zml.schema.bind;
import java.util.ArrayList;
public class ExpressGroup extends Express
{
	private OperationLogical logicship;
	private ArrayList<Express> express = new ArrayList<Express>();
	public OperationLogical getLogicship()
	{
		return this.logicship;
	}
	public void setLogicship(OperationLogical inlogicship )
	{
		this.logicship = inlogicship;
	}
	public ArrayList<Express> getExpress()
	{
		return this.express;
	}
	public void setExpress(ArrayList<Express> inexpress )
	{
		this.express = inexpress;
	}
}