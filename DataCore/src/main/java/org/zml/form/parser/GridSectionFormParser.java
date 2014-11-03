package org.zml.form.parser;
import org.zml.form.bind.GridSection;
public class GridSectionFormParser extends FormParser implements FormParserAble
{
	public GridSectionFormParser( GridSection element)
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
		if ( !(this.getQueryDefineElement() instanceof GridSection))
		{
			throw new Exception(" GridSectionFormParser only parse GridSection");
		}
		result = true;
		return result;
	}
}