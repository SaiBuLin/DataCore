package org.zml.form.parser;
import org.zml.form.bind.SectionGroup;
public class SectionGroupFormParser extends FormParser implements FormParserAble
{
	public SectionGroupFormParser( SectionGroup element)
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
			throw new Exception(" SectionGroupFormParser only parse SectionGroup");
		}
		result = true;
		return result;
	}
}