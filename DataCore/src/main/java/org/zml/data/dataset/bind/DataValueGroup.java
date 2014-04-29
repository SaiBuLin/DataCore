package org.zml.data.dataset.bind;
import java.util.ArrayList;
public class DataValueGroup extends MyValue
{
	private ArrayList<MyValue> myValue = new ArrayList<MyValue>();
	public ArrayList<MyValue> getMyValue()
	{
		return this.myValue;
	}
	public void setMyValue(ArrayList<MyValue> inmyValue )
	{
		this.myValue = inmyValue;
	}
}