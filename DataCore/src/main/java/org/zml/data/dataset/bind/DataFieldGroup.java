package org.zml.data.dataset.bind;
import java.util.ArrayList;
public class DataFieldGroup extends DataField
{
	private ArrayList<DataField> dataField = new ArrayList<DataField>();
	public ArrayList<DataField> getDataField()
	{
		return this.dataField;
	}
	public void setDataField(ArrayList<DataField> indataField )
	{
		this.dataField = indataField;
	}
}