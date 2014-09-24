package org.zml.form.parser;
import org.zml.form.bind.SectionGroup;
public class SectionGroupDemandForm extends DemandForm implements DemandFormAble
{
	public SectionGroupDemandForm( SectionGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof SectionGroup))
		{
			throw new Exception(" SectionGroupDemandForm only parse SectionGroup");
		}
		result = true;
		return result;
	}
}