package org.zml.form.parser;
import org.zml.form.bind.Section;
public class SectionFormParser extends FormParser implements FormParserAble
{
	public SectionFormParser( Section element)
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
			throw new Exception(" SectionFormParser only parse Section");
		}
		result = true;
		return result;
	}
}