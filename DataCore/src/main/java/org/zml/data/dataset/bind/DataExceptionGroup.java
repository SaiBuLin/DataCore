package org.zml.data.dataset.bind;
import java.util.ArrayList;
public class DataExceptionGroup extends DataException
{
	private ArrayList<DataException> dataException = new ArrayList<DataException>();
	public ArrayList<DataException> getDataException()
	{
		return this.dataException;
	}
	public void setDataException(ArrayList<DataException> indataException )
	{
		this.dataException = indataException;
	}
}