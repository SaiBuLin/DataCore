package org.zml.form.parser;
import org.zml.form.bind.Section;
public class SectionDemandForm extends DemandForm implements DemandFormAble
{
	public SectionDemandForm( Section element)
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
		if ( !(this.getQueryDefineElement() instanceof Section))
		{
			throw new Exception(" SectionDemandForm only parse Section");
		}
		result = true;
		return result;
	}
}