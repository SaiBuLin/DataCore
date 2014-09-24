package org.zml.form.parser;
import org.zml.form.bind.FieldColumn;
public class FieldColumnDemandForm extends DemandForm implements DemandFormAble
{
	public FieldColumnDemandForm( FieldColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldColumn))
		{
			throw new Exception(" FieldColumnDemandForm only parse FieldColumn");
		}
		result = true;
		return result;
	}
}