package org.zml.form.parser;
import org.zml.form.bind.ColumnGroup;
public class ColumnGroupDemandForm extends DemandForm implements DemandFormAble
{
	public ColumnGroupDemandForm( ColumnGroup element)
	{
		setQueryDefineElement(element);
	}
	public boolean checkQueryElementComfort() throws Exception
	{
		boolean result = false;
		if ( this.getQueryDefineElement()  == null )
		{
			throw new Exception(" queryDefineElement cannot be null. ");
		}
		if ( !(this.getQueryDefineElement() instanceof ColumnGroup))
		{
			throw new Exception(" ColumnGroupDemandForm only parse ColumnGroup");
		}
		result = true;
		return result;
	}
}