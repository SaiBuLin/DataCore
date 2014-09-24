package org.zml.form.parser;
import org.zml.form.bind.AnalystColumn;
public class AnalystColumnDemandForm extends DemandForm implements DemandFormAble
{
	public AnalystColumnDemandForm( AnalystColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof AnalystColumn))
		{
			throw new Exception(" AnalystColumnDemandForm only parse AnalystColumn");
		}
		result = true;
		return result;
	}
}