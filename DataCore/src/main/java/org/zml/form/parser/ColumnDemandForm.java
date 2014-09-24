package org.zml.form.parser;
import org.zml.form.bind.Column;
public class ColumnDemandForm extends DemandForm implements DemandFormAble
{
	public ColumnDemandForm( Column element)
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
		if ( !(this.getQueryDefineElement() instanceof Column))
		{
			throw new Exception(" ColumnDemandForm only parse Column");
		}
		result = true;
		return result;
	}
}