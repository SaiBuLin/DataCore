package org.zml.form.parser;
import org.zml.form.bind.ColumnSection;
public class ColumnSectionDemandForm extends DemandForm implements DemandFormAble
{
	public ColumnSectionDemandForm( ColumnSection element)
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
		if ( !(this.getQueryDefineElement() instanceof ColumnSection))
		{
			throw new Exception(" ColumnSectionDemandForm only parse ColumnSection");
		}
		result = true;
		return result;
	}
}