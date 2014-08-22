package org.zml.form.parser;
import org.zml.form.bind.SelectSection;
public class SelectSectionFormParser extends FormParser implements FormParserAble
{
	public SelectSectionFormParser( SelectSection element)
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
		if ( !(this.getQueryDefineElement() instanceof SelectSection))
		{
			throw new Exception(" SelectSectionFormParser only parse SelectSection");
		}
		result = true;
		return result;
	}
}